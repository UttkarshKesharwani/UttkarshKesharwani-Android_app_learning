package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragment.databinding.FragmentBlankBinding

class BlankFragment2 : Fragment() {
    private lateinit var binding: FragmentBlankBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentBlankBinding.inflate(inflater,container,false)
        Toast.makeText(requireContext(), "this is fragment 2", Toast.LENGTH_SHORT).show()

        return binding.root

    }

    companion object {

    }
}