package dev.anand

fun main(){
    val appRatings = mapOf(
        "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
        "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
        "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
    )
    val averageRatings = mutableMapOf<String, Double>()

    appRatings.forEach{
        val total = it.value.reduce{
            a,b -> a+b
        }
        averageRatings[it.key] = total.toDouble()/it.value.size
    }

    println(averageRatings)

    val topApps = averageRatings.filter {
        it.value >= 3

    }.map { it.key }
    println(topApps)

}