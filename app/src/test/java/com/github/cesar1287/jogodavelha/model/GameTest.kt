package com.github.cesar1287.jogodavelha.model

import org.junit.Assert.assertTrue
import org.junit.Test

class GameTest {

    @Test
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow1() {
        val game = Game("Cesar", "1MOB")
        val player = game.player1

        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell

        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()

        assertTrue(hasThreeSameHorizontalCells)
    }
}
