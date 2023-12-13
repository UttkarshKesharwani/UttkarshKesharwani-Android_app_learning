package com.example.shoopingappadmin

class ProductModel {
    var name :String=" "
    var price :Double=-1.0
    var discription :String=" "
    var imageUrl :String=" "
    var category:String=" "




    constructor()
    constructor(
        name: String,
        price: Double,
        discription: String,
        imageUrl: String,
        category: String
    ) {
        this.name = name
        this.price = price
        this.discription = discription
        this.imageUrl = imageUrl
        this.category = category
    }

}