package com.github.cesar1287.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.cesar1287.jogodavelha.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private val binding: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}