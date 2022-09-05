package dev.anand

fun main(){
    val countries = arrayOf(
        "India", "Japan", "China", "Germany",
        "New Zealand", "South Africa", "Australia"
    )

    val countriesList = listOf("Benin", "Burkina Faso", "Cape Verde")
    val mutableList = countries.toMutableList()

    mutableList.add("Nigeria")
    mutableList.add(1, "Ghana")

    println(countries)
    println(mutableList)

    println(countries.size)
    println(mutableList.size)

    mutableList.addAll(listOf("Senegal", "Sierra Leone", "Togo"))
    println(mutableList)

    mutableList.addAll(countriesList)
    println(mutableList)

    val isWestAfricanCountry = "Tanzania" in mutableList
    println(isWestAfricanCountry)

    mutableList.remove("Cape Verde")
    mutableList.removeAt(0)
    mutableList.removeAll(listOf("Senegal", "Sierra Leone", "Togo"))
    println(mutableList)

    mutableList[2] = "Guinea"
    val combinedList = countries + mutableList
    val emptyList = emptyList<String>()


    println(mutableList)
    println(combinedList)
    println(emptyList)


    mutableList.clear()
    println(mutableList)
}