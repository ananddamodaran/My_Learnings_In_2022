package dev.anand

fun main(){
    val movies = arrayOf("Inception", "John Wick", "Taken", "Parasite", "Avengers")

    movies[2] = "The Lion King"
    println(movies[2])

    val moviesList = movies.toMutableList()
    moviesList.addAll(listOf("Avatar: The Way of the Water", "Nope"))
    moviesList.remove("Taken")
    println(moviesList)

    println("Taken" in moviesList)

}