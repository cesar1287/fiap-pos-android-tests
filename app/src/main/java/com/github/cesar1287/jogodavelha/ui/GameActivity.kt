package com.github.cesar1287.jogodavelha.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.github.cesar1287.jogodavelha.R
import com.github.cesar1287.jogodavelha.databinding.ActivityGameBinding
import com.github.cesar1287.jogodavelha.model.Player

class GameActivity : AppCompatActivity() {

    private val viewModel: GameViewModel by lazy {
        ViewModelProvider(this)[GameViewModel::class.java]
    }

    private val binding: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        promptForPlayers()
    }

    // método para setar o jogadores que serão preenchidos pelo dialog
    fun onPlayersSet(player1: String?, player2: String?) {
        initDataBinding(player1, player2)
    }

    // Exibe o dialog solicitando o nome dos jogadores
    fun promptForPlayers() {
        val dialog = GameBeginDialog.newInstance(this)
        dialog.isCancelable = false
        dialog.show(supportFragmentManager, GAME_BEGIN_DIALOG_TAG)
    }

    private fun initDataBinding(player1: String?, player2: String?) {
        val activityGameBinding = DataBindingUtil.setContentView<ActivityGameBinding>(this, R.layout.activity_game)
        viewModel.init(player1, player2)
        activityGameBinding.gameViewModel = viewModel
        setUpOnGameEndListener()
    }

    private fun setUpOnGameEndListener() {
        viewModel.winner.observe(this) { this.onGameWinnerChanged(it) }
    }

    internal fun onGameWinnerChanged(winner: Player?) {
        val winnerName = if (winner == null || winner.name.isEmpty()) NO_WINNER else winner.name
        val dialog = GameEndDialog.newInstance(this, winnerName)
        dialog.isCancelable = false
        dialog.show(supportFragmentManager, GAME_END_DIALOG_TAG)
    }

    companion object {

        private const val GAME_BEGIN_DIALOG_TAG = "game_dialog_tag"
        private const val GAME_END_DIALOG_TAG = "game_end_dialog_tag"
        private const val NO_WINNER = "No one"
    }
}