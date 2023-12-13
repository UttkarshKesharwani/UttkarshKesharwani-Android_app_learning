package com.example.kotlinbasics

fun main(){
    var arraylist = ArrayList<Int>()

    arraylist.add(3)
    arraylist.add(4)
    arraylist.add(5)
    arraylist.add(6)

    arraylist.forEach(){
        println(it)
    }



}