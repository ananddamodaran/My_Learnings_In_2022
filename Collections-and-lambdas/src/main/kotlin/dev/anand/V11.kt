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
}