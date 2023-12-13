package com.example.kotlinbasics

fun main() {
    val obj=child()
    obj.myname()
    obj.myname2()
    println(obj.name)
    obj.name="rajkishor"
    println(obj.name)
}
open class parent{
    var name="brajkishor"
    init{
        println("parent class")
    }
    fun myname(){
        println("i m in parent class")
    }
}
class child : parent(){
    val name2 ="nikhl"
    init{
        println("child class")
    }
    fun myname2(){
        println("i m in child class")

    }

}