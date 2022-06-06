package dev.damodaran.testcompose.storage.data

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.damodaran.testcompose.LOG_TAG
import dev.damodaran.testcompose.storage.api.HeaderInterceptor
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

const val BASE_ENDPOINT_URL = "https://2873199.youcanlearnit.net/"

class ProductRepository(private val app: Application) {
    private val moshi: Moshi by lazy {
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .build()
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private val productApi: ProductApi by lazy {
        retrofit.create(ProductApi::class.java)
    }

    private val productDao = ProductDatabase.getDatabase(app)
        .productDao()


    /*suspend fun getProducts(): List<Product> {
        *//*val productsFromCache = readDataFromFile()
        if (productsFromCache.isNotEmpty()) {
            Log.i(LOG_TAG, "loaded from cache")
            return productsFromCache
        }
*//*
        val response = productApi.getProducts()
        return if (response.isSuccessful) {
            Log.i(LOG_TAG, "loaded from webservice")
            val products = response.body() ?: emptyList()
            //storeDataInFile(products)
            storeDataInDb(products)
            products
        } else
            emptyList()
    }*/
    private suspend fun storeDataInDb(products: List<Product>?) {
        if (products != null) {
            productDao.insertProducts(products)
        }
    }
    fun getProducts(): Flow<List<Product>> {
        return productDao.getProducts()
    }
    suspend fun loadProducts() {
        if (productDao.getCount() <= 0) {
            val response = productApi.getProducts()
            if (response.isSuccessful) {
                Log.i(LOG_TAG, "loaded from webservice")
                val products = response.body() ?: emptyList()
                storeDataInDb(products)
            }
        }
    }

    private fun storeDataInFile(products: List<Product>?) {
        if (ContextCompat.checkSelfPermission(
                app,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED) {
            val listType = Types.newParameterizedType(List::class.java, Product::class.java)
            val fileContents = moshi.adapter<List<Product>>(listType)
                .toJson(products)

            //val file = File(app.filesDir, "products.json")
            // val file = File(app.cacheDir, "products.json")
             val file = File(app.getExternalFilesDir("products"), "products.json")

            file.writeText(fileContents)
        }

    }

    fun getTotalQuantity(): Flow<Int> {
        return productDao.getTotalQuantity()
    }

    suspend fun updateProduct(product: Product) {
        productDao.updateProduct(product)
    }
    private fun readDataFromFile(): List<Product> {
        val file = File(
            app.getExternalFilesDir("products"),
            "products.json"
        )
        // val file = File(app.cacheDir, "products.json")
        val json = if (file.exists()) file.readText() else null

        return if (json == null)
            emptyList()
        else {
            val listType = Types.newParameterizedType(List::class.java, Product::class.java)
            moshi.adapter<List<Product>>(listType).fromJson(json) ?: emptyList()
        }
    }
}