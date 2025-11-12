package com.mahshad.tictactoe.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeBoardViewModel @Inject constructor() : ViewModel() {
    val board = mutableMapOf(
        0 to 'A',
        1 to 'B',
        2 to 'C',
        3 to 'D',
        4 to 'E',
        5 to 'F',
        6 to 'G',
        7 to 'H',
        8 to 'I'
    )
    private val turnStateFlow = MutableStateFlow(true)
    val _turnStateFlow = turnStateFlow.asStateFlow()

    private val gameOverFlow = MutableStateFlow(false)
    val _gameOverFlow = turnStateFlow.asStateFlow()

    private fun updateTurn() {
        turnStateFlow.update { !it }
    }

    private fun checkGameOver() {
        val status = setOf(board[0], board[4], board[8]).size == 1 ||
                setOf(board[2], board[4], board[6]).size == 1 ||
                setOf(board[0], board[3], board[6]).size == 1 ||
                setOf(board[1], board[4], board[7]).size == 1 ||
                setOf(board[2], board[5], board[8]).size == 1 ||
                setOf(board[0], board[1], board[2]).size == 1 ||
                setOf(board[3], board[4], board[5]).size == 1 ||
                setOf(board[6], board[7], board[8]).size == 1
        gameOverFlow.update { status }
    }

    fun updateBoard(index: Int) {
        if (turnStateFlow.value) board[index] = 'X' else board[index] = 'Y'
        checkGameOver()
        updateTurn()
    }
}