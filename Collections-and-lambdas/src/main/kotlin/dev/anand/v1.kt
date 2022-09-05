package dev.anand

fun main() {
    val firstName = "Anand"
    val lastName = "Damodaran"
    val age = 35

    val birthday = Triple(19, "Jan", 1987)

    val person = Pair("Anand Damodaran", birthday)
    val nameUsingOrdering = person.first
    val birthdayUsingOrdering = person.second
    println("$nameUsingOrdering - $birthdayUsingOrdering")
    val (name, bday) = person

    val (dayOfBirth, birthMonth, _) = bday

    val yearOfBirth = birthdayUsingOrdering.third

    println("$name was born on $dayOfBirth $birthMonth, year unknown!")

}