package com.mahshad.tictactoe.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeBoardViewModel @Inject constructor() : ViewModel() {
    val board = List(6) { -1 }
    private val turnStateFlow = MutableStateFlow(true)
    val _turnStateFlow = turnStateFlow.asStateFlow()

    private val gameOverFlow = MutableStateFlow(false)
    val _gameOverFlow = turnStateFlow.asStateFlow()

    fun updateTurn() {
        turnStateFlow.update { !it }
    }

    fun checkGameOver() {}
}