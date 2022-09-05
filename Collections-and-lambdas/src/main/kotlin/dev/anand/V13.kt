package dev.anand

fun main() {
    val pets = mutableMapOf<String, String>()
    pets["Ozma"] = "Domestic Medium Hair Cut"
    pets["Zuri"] = "Black Hamster"
    pets["Migos"] = "Golden Retriever Dog"

    println(pets)
    pets.remove("Ozma")
    println(pets)

    val petsMap = mapOf(
        "Ozma" to "Domestic Medium Hair Cut 2",
        "Zuri" to "Black Hamster 2",
        "Migos" to "Golden Retriever Dog 2"

    )

    for((name,breed) in petsMap){
        println("The pet $name is a $breed")
    }
}