package com.github.cesar1287.jogodavelha.ui

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.adevinta.android.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.adevinta.android.barista.interaction.BaristaEditTextInteractions.writeTo
import com.github.cesar1287.jogodavelha.R
import org.junit.Rule
import org.junit.Test

class GameBeginDialogTest {

    @Rule
    @JvmField
    var activityRule: ActivityScenarioRule<GameActivity> = ActivityScenarioRule(GameActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun display_same_names_message_if_names_same() {
        writeTo(R.id.et_player1, "Heider")
        writeTo(R.id.et_player2, "Heider")

        clickDialogPositiveButton()

        assertDisplayed(R.string.game_dialog_same_names)
    }

    @Test
    @Throws(Exception::class)
    fun display_empty_name_message_if_one_name_empty() {
        writeTo(R.id.et_player1, "")
        writeTo(R.id.et_player2, "Android")

        clickDialogPositiveButton()

        assertDisplayed(R.string.game_dialog_empty_name)
    }

    @Test
    @Throws(Exception::class)
    fun close_dialog_after_names_valid() {
        writeTo(R.id.et_player1, "Heider 1")
        writeTo(R.id.et_player2, "Android")

        clickDialogPositiveButton()

        assertNotExist(R.id.player1Layout)
    }
}