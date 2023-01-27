package com.example.recyclervieweducacionit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.recyclervieweducacionit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val fragmentManager: FragmentManager by lazy { supportFragmentManager }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    private fun init() {
        fragmentManager.beginTransaction()
            .replace(R.id.contenedor_fragments, ProductsFragment())
            .commit()
    }

}