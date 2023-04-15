package com.github.cesar1287.jogodavelha.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.github.cesar1287.jogodavelha.R
import com.github.cesar1287.jogodavelha.databinding.GameEndDialogBinding

class GameEndDialog : DialogFragment() {

    private val rootView: GameEndDialogBinding by lazy {
        GameEndDialogBinding.inflate(layoutInflater, null, false)
    }
    private var activity: GameActivity? = null
    private var winnerName: String? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initViews()
        val alertDialog = AlertDialog.Builder(context)
            .setView(rootView.root)
            .setCancelable(false)
            .setPositiveButton(R.string.done) { _, _ -> onNewGame() }
            .create()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.setCancelable(false)
        return alertDialog
    }

    private fun initViews() {
        rootView.tvWinner.text = winnerName
    }

    private fun onNewGame() {
        dismiss()
        activity?.promptForPlayers()
    }

    companion object {
        fun newInstance(activity: GameActivity, winnerName: String): GameEndDialog {
            val dialog = GameEndDialog()
            dialog.activity = activity
            dialog.winnerName = winnerName
            return dialog
        }
    }
}