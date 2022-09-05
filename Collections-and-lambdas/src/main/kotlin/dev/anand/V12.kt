package dev.anand

fun main(){
    val moviesCollection = mutableMapOf<String, MutableList<String>>()
    println(moviesCollection)

    moviesCollection["Action"] = mutableListOf("Taken", "John Wick")
    println(moviesCollection)

    val actionMovies = moviesCollection["Action"]
    println(actionMovies)

    val horrorMovies = moviesCollection["Horror"]
    println(horrorMovies)

    val authenticationHeaders = mapOf(
        "API_KEY" to "your-api-key",
        "Authorization" to "auth token",
        "content/type" to "application/json"
    )
    println(authenticationHeaders)

    moviesCollection["Horror"] = mutableListOf()
    println(moviesCollection)

    moviesCollection["Horror"] = mutableListOf("Get Out")
    println(moviesCollection)

    moviesCollection["Horror"]?.add("Midsommer")
    println(moviesCollection)

    val removedActionMovies = moviesCollection.remove("Action")
    println(removedActionMovies)
    println(moviesCollection)

    moviesCollection["Horror"]?.add("It Comes At Night")
    moviesCollection["Comedy"] = mutableListOf("ted")

    for (key in moviesCollection.keys){
        println(println(key))
    }

    for(value in moviesCollection.values){
        println(value)
    }

    for ((key, value) in moviesCollection) {
        println("Movies in the $key genre you own are: $value")
    }

}