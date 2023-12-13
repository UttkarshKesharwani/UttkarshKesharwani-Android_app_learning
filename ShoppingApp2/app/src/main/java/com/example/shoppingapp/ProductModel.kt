package com.example.shoppingapp


class ProductModel {
    var id: String=" "
    var name :String=" "
    var price :Double=-1.0
    var discription :String=" "
    var imageUrl :String=" "
    var productCode:String=""


    constructor(name: String, price: Double, discription: String, imageUrl: String) {
        this.name = name
        this.price = price
        this.discription = discription
        this.imageUrl = imageUrl
        this.productCode=productCode
    }
    constructor()
}