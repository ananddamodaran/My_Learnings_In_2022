package dev.anand

fun main(){
    val items = listOf("Phone","Notebook","Pen","Water Bottle","Phone")

    val uniqueItems = items.toMutableSet()
    println(uniqueItems)

    println(uniqueItems.remove("Pen"))
    println(uniqueItems.remove("Notebook"))

    for (item in uniqueItems){
        println(item)
    }


}