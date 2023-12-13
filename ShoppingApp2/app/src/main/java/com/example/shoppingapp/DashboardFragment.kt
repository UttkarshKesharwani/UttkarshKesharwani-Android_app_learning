package com.example.shoppingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shoppingapp.databinding.FragmentDashboardBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject


class DashboardFragment : Fragment() {
    private lateinit var productList: ArrayList<ProductModel>
    private lateinit var adapter: ProductAdapter
    private val binding by lazy {
        FragmentDashboardBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productList= ArrayList()
        adapter = ProductAdapter(requireContext(), productList)
        binding.mainRv.adapter=adapter
        getProductData()


    }

    private fun getProductData() {


        Firebase.firestore.collection("Products").limit(10).get().addOnSuccessListener {
            productList.clear()
            for(i in it.documents){

                var tempProductModel=i.toObject<ProductModel>()
                productList.add(tempProductModel!!)
            }
            adapter.notifyDataSetChanged()

        }
            .addOnFailureListener(){
                Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
            }

    }

    companion object {

    }


}