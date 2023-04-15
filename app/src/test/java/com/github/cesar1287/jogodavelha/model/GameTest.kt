package com.github.cesar1287.jogodavelha.model

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GameTest {

    private lateinit var game: Game
    private var player: Player? = null
    private var anotherPlayer: Player? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Heider", "Android")
        player = game.player1
        anotherPlayer = game.player2
    }


    @Test
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow1() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell

        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()

        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow2() {
        val cell = Cell(player)
        game.cells[1][0] = cell
        game.cells[1][1] = cell
        game.cells[1][2] = cell

        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()

        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow3() {
        val cell = Cell(player)
        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = cell

        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()

        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameHorizontalCells() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game.cells[0][0] = cell
        game.cells[0][1] = cell

        game.cells[0][2] = anotherCell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertFalse(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn1() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn2() {
        val cell = Cell(player)
        game.cells[0][1] = cell
        game.cells[1][1] = cell
        game.cells[2][1] = cell
        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn3() {
        val cell = Cell(player)
        game.cells[0][2] = cell
        game.cells[1][2] = cell
        game.cells[2][2] = cell
        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameVerticalCells() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)

        game.cells[0][2] = cell
        game.cells[1][2] = cell
        game.cells[2][2] = anotherCell

        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()
        assertFalse(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameDiagonalCellsFromLeft() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameDiagonalCellsFromRight() {
        val cell = Cell(player)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = cell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameDiagonalCells() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = anotherCell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertFalse(hasThreeSameDiagonalCells)
    }

    //00 01 02
    //10 11 12
    //20 21 22
}
