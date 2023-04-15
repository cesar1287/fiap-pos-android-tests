package com.github.cesar1287.jogodavelha.ui

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.adevinta.android.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.github.cesar1287.jogodavelha.R
import com.github.cesar1287.jogodavelha.model.Player
import org.junit.Rule
import org.junit.Test

class GameEndDialogTest {

    @Rule
    @JvmField
    var activityRule: ActivityScenarioRule<GameActivity> = ActivityScenarioRule(GameActivity::class.java)

    private fun givenGameEnded() {
        activityRule.scenario.onActivity {
            it.onGameWinnerChanged(Player("Heider", "x"))
        }
    }

    @Test
    @Throws(Exception::class)
    fun display_winner_when_game_ends() {
        givenGameEnded()

        assertDisplayed(R.id.tvWinner)
    }

    @Test
    @Throws(Exception::class)
    fun display_begin_dialog_when_done_clicked() {
        givenGameEnded()

        clickDialogPositiveButton()

        assertNotExist(R.id.tvWinner)

        assertDisplayed(R.id.et_player1)
    }
}

