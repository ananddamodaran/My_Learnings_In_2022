package dev.anand

fun main(){
    val visitedCountries = arrayOf(
        "Russia", "USA", "Poland",
        "The Netherlands", "Romania", "Greece",
        "Germany", "Spain", "Portugal",
        "Serbia", "Hungary", "Austria"
    )

    val players = mutableListOf("Alice", "Bob", "Cindy", "Dan")

    for (countryIndex in 0..visitedCountries.lastIndex) {
        print("${visitedCountries[countryIndex]} ")
    }

    println()
    for (country in visitedCountries) {
        print("$country ")
    }

    println()
    for (player in players) {
        print("$player ")
    }
    println()
    for ((index, player) in players.withIndex()) {
        println("${index + 1}.  $player")
    }

}