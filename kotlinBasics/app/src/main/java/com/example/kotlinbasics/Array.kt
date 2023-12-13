package com.example.kotlinbasics

fun main(){
    var arr= arrayOf<Int>(10,20,30,40,50)

    for(i in arr){ // To print array
        println(i)
    }
    println()
    arr.forEach { // other way to print array
        println(it)
    }
    println()
    arr.reverse() // this function reverse the array
    for(i in arr){
        println(i)
    }
    println()
    arr.shuffle()
    for(i in arr){
        println(i)
    }

    println()

    // we can do
    println(arr.get(3))
    println(arr.size)
    println(arr.indexOf(30)) // by this line we can access the index using element
}