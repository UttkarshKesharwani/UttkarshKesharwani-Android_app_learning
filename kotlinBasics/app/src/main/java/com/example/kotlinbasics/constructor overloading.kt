package com.example.kotlinbasics

fun main(){
    val nikhil=person()
}

class person{  // jab ham log secondary constructor bnaege to class ka name banate samaay brackets nhi dena pdta
                         // kyuki bracket jb diye jate hai jab ham log primaty constructor ko call krna hota h
    constructor(age:Int){
        println(age)
    }
    constructor(){
        println("No parameter passed")
    }
}