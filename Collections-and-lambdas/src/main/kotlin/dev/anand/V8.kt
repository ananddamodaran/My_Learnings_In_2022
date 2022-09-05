package dev.anand

fun main(){
    println(sumOfElements(listOf(2, 2, 8, 6, 1)))
}
fun sumOfElements(list: List<Int>): Int {
    var sum = 0
    for (number in list) {
        sum += number
    }
    return sum
}