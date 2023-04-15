package com.github.cesar1287.jogodavelha.ui

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

    // método para setar o jogadores que serão preenchidos pelo dialog
    fun onPlayersSet(player1: String?, player2: String?) {

    }

    // Exibe o dialog solicitando o nome dos jogadores
    fun promptForPlayers() {

    }

}