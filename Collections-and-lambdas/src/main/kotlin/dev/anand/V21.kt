package dev.anand

fun main(){
    val lotsOfDwarves = listOf(
        listOf("Sleepy", "Grumpy", "Doc", "Bashful", "Sneezy"),
        listOf("Thorin", "Nori", "Bombur")
    )
    println(lotsOfDwarves)

    val (beforeM, mAndAfter) = lotsOfDwarves.flatMap { dwarfs ->
        dwarfs.filter { it.length > 3 }
    }.sortedBy { -it.length }.partition { it < "M" }
    val groupBeforeM = beforeM.groupBy { it.first() }

    println(groupBeforeM)
    println(mAndAfter)
}