package com.example.kotlinbasics

fun main(){
    var a=15
    var b=0
    try{
        println(a/b)
    }catch(q:Exception){
        println("divide by 0")
        println(q.localizedMessage) // to print which type of acception occured
    }

    finally{  // try and catch me ek chalega lekin finally block chalega hi chalega
        println("work done")
    }

}