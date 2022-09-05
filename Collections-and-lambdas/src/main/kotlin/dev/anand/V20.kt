package dev.anand

fun main() {
    var prices = arrayOf(1.50, 10.00, 4.99, 2.30, 8.19)
    for (price in prices) {
        println(price)
    }

    prices.forEach(::println)


    println()
    var salePrices = mutableListOf<Double>()
    for (price in prices) {
        salePrices.add(price * 0.9)
    }
    println(salePrices)

    val salePricesLambda = prices.map { it * 0.9 }
    println(salePricesLambda)

    val largePrices = prices.filter { it > 5.0 }
    println(largePrices)

    val sum = prices.reduce {a, b ->
        a + b
    }
    println(sum)

    val userInput = listOf("meow!", "15", "37.5", "seven", "42")

    val numbers = userInput.map {
        it.toIntOrNull()
    }
    println(numbers)

    val validInput = userInput.mapNotNull {
        it.toIntOrNull()
    }
    println(validInput)

}