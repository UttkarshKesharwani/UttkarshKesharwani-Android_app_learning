package com.example.shoppingapp

 import android.content.Intent
 import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingapp.databinding.ActivitySignupLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.database

class SignupLoginActivity : AppCompatActivity() {
    val binding by lazy {
        ActivitySignupLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signup.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(binding.email.text.toString(),binding.createPasswrod.text.toString()).addOnCompleteListener{

                if(it.isSuccessful){
                    var userModel = userModel(binding.firstName.text.toString(),binding.lastName.text.toString(),binding.email.text.toString(),binding.createPasswrod.text.toString())
                    Firebase.database.reference.child("My Users").child(it.result.user!!.uid).setValue(userModel).addOnSuccessListener {
                        startActivity(Intent(this@SignupLoginActivity,HomeActivity ::class.java))
                    }

                        .addOnFailureListener(){
                            Toast.makeText(this@SignupLoginActivity, it .localizedMessage, Toast.LENGTH_SHORT).show()
                        }

                }
                else{
                    Toast.makeText(this@SignupLoginActivity, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                }



            }

        }





    }
}