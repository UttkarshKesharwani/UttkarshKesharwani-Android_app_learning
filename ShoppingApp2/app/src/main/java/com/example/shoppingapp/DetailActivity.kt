package com.example.shoppingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.shoppingapp.databinding.ActivityDetailBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class DetailActivity : AppCompatActivity() {
   private val binding by lazy {
       ActivityDetailBinding.inflate(layoutInflater)
   }
    var productModel=ProductModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val productId = intent.getStringExtra("PRODUCT_ID")


        Firebase.firestore.collection("Products").document(productId!!).get().addOnSuccessListener {

            productModel=it.toObject<ProductModel>()!!
            productModel.id=it.id
            binding.productImage.load(productModel.imageUrl)
        }






    }
}