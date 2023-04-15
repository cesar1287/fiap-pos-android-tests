package com.github.cesar1287.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.cesar1287.jogodavelha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}