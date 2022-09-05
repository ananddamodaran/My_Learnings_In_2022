package dev.anand

fun main() {
    //  val country1 = "India"
    //  val country2 = "Japan"
    //  val country3 = "Germany"
    val countries = arrayOf(
        "India", "Japan", "China", "Germany",
        "New Zealand", "South Africa", "Australia"
    )
    println(countries)
    println(countries.size)
    println(countries[3])
    println(countries.get(3))

    //println(countries[20])
    //println(countries[-1])

    val updatedArray = countries + "Mauritius"
    println(updatedArray.size)

    countries[3] = "Ivory Coast"
    println(countries[3])

    val sizedArray = Array(10) {""}
    val emptyArray = emptyArray<String>()

    val arrayOfInts = intArrayOf(2, 3, 4, 5, 6, 7)
    println(arrayOfInts)

    val intArray = IntArray(10)
    println(intArray)

    println(countries.lastIndex)
    println(countries.last())
    println(countries.first())

    val currentCountry = "Mauritius"
    println(countries.contains(currentCountry))

    val isWestAfricanCountry = currentCountry in countries
    val isNotWestAfricanCountry = currentCountry !in countries

    println(isWestAfricanCountry)
    println(isNotWestAfricanCountry)



}