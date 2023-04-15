package com.github.cesar1287.jogodavelha.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.TextUtils
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.DialogFragment
import com.github.cesar1287.jogodavelha.R
import com.github.cesar1287.jogodavelha.databinding.GameBeginDialogBinding
import com.google.android.material.textfield.TextInputLayout

class GameBeginDialog : DialogFragment() {

    private var player1: String? = ""
    private var player2: String? = ""

    private val rootView: GameBeginDialogBinding by lazy {
        GameBeginDialogBinding
            .inflate(layoutInflater, null, false)
    }

    private lateinit var activity: GameActivity

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initViews()
        val alertDialog = AlertDialog.Builder(context)
            .setView(rootView.root)
            .setTitle(R.string.game_dialog_title)
            .setCancelable(false)
            .setPositiveButton(R.string.done, null)
            .create()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.setCancelable(false)
        alertDialog.setOnShowListener { onDialogShow(alertDialog) }
        return alertDialog
    }

    private fun initViews() {
        addTextWatchers()
    }

    private fun addTextWatchers() {
        with(rootView) {
            etPlayer1.doAfterTextChanged {
                player1 = it?.toString()
            }
            etPlayer2.doAfterTextChanged {
                player2 = it?.toString()
            }
        }
    }

    private fun onDialogShow(dialog: AlertDialog) {
        val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        positiveButton.setOnClickListener { onDoneClicked() }
    }

    private fun onDoneClicked() {
        with(rootView) {
            if (isAValidName(player1Layout, player1) and
                isAValidName(player2Layout, player2)
            ) {
                activity.onPlayersSet(player1, player2)
                dismiss()
            }
        }
    }

    private fun isAValidName(layout: TextInputLayout?, name: String?): Boolean {
        if (TextUtils.isEmpty(name)) {
            layout?.isErrorEnabled = true
            layout?.error = getString(R.string.game_dialog_empty_name)
            return false
        }
        if (player1.equals(player2, ignoreCase = true)) {
            layout?.isErrorEnabled = true
            layout?.error = getString(R.string.game_dialog_same_names)
            return false
        }
        layout?.isErrorEnabled = false
        layout?.error = ""
        return true
    }

    companion object {

        fun newInstance(activity: GameActivity): GameBeginDialog {
            val dialog = GameBeginDialog()
            dialog.activity = activity
            return dialog
        }
    }
}