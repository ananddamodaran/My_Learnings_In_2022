package dev.anand


fun main() {
    val firstName = "Anand"
    val lastName = "Damodaran"
    val age = 35

    val creditCard = Triple("303012958531", "007", "Visa")
    val bankAccount = Pair(16000.0, creditCard)

    val (balance, card) = bankAccount
    val (cardNumber, securityCode, cardType) = creditCard

    println("The account has $balance, with the cardNumber: $cardNumber and the cardType: $cardType, security: ***")
}