package dev.anand

fun main(){
    var userIds = setOf("ID1B", "ID2C", "ID3F", "ID8I")
    println(userIds)
    println(userIds.contains("ID2C"))
    println("ID3F" in userIds)

    val mutableIds = userIds.toMutableSet()
    println(mutableIds.add("ID0Z"))
    println(mutableIds)

    println(mutableIds.add("ID1B"))
    println(mutableIds)

    for(userId in mutableIds){
        println(userId)
    }

    val names = arrayOf("Anand","Rahini","Kavin","Nivin","Rahini")
    val uniqueNames = names.toSet()
    println(uniqueNames)

}