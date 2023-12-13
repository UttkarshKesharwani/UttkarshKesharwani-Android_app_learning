package com.example.shoopingappadmin

import android.R
import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.shoopingappadmin.databinding.ActivityMainBinding
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage
import java.util.UUID

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    var productModel = ProductModel()


    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                binding.rootLayout.setBackgroundColor(Color.DKGRAY)
                binding.mainLayout.visibility= View.GONE
                binding.spinKit.visibility=View.VISIBLE
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!

                Firebase.storage.reference.child("product image/${UUID.randomUUID()}").putFile(fileUri).addOnCompleteListener {
                    if(it.isSuccessful){
                         it.result.storage.downloadUrl.addOnSuccessListener {
                             productModel.imageUrl=it.toString()
                             binding.productImage.setImageURI(fileUri)
                             binding.mainLayout.visibility=View.VISIBLE
                             binding.spinKit.visibility=View.GONE
                             binding.rootLayout.setBackgroundColor(Color.WHITE)
                         }

                    }

                }

                binding.productImage.setImageURI(fileUri)
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var arrayAdapter= ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayOf("Dresses","BottomSuit","Tops","Jumpsuits")
        )

        binding.category.adapter=arrayAdapter

        binding.productImage.setOnClickListener {
            ImagePicker.with(this)
                .compress(1024)
                .crop()//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)  //Final image resolution will be less than 1080 x 1080(Optional)
                .createIntent { intent ->
                    startForProfileImageResult.launch(intent)
                }



            binding.category.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                    productModel.category=categoryList.get(p2)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }


            binding.addProduct.setOnClickListener {
                if(binding.productName.text.toString().isEmpty()){
                    binding.productName.setError("please enter product name")
                }else if(binding.price.text.toString().isEmpty()){
                    binding.price.setError("please enter price")
                }else if(binding.Discription.text.toString().isEmpty()){
                    binding.Discription.setError("please enter discription")
                }
                else {
                    productModel.name = binding.productName.text.toString()
                    productModel.discription = binding.Discription.text.toString()
                    productModel.price = binding.price.text.toString().toDouble()

                    Firebase.firestore.collection("Products").document(UUID.randomUUID().toString())
                        .set(productModel).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "product added", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, " product not added", Toast.LENGTH_SHORT).show()
                        }
                    }


                }
            }




        }
    }
}