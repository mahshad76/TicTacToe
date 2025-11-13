package com.mahshad.tictactoe.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeBoardGame(
    homeBoardViewModel: HomeBoardViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    //val turnStateFlow = homeBoardViewModel._turnStateFlow.collectAsStateWithLifecycle()
    val gameOverFlow = homeBoardViewModel._gameOverFlow.collectAsStateWithLifecycle()
    val grid = (0..8).toList()

    Card(modifier = modifier) {
        grid.chunked(3).forEach { row ->
            Row() {
                row.forEach { item ->
                    Text(
                        text = item.toString(),
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .size(50.dp)
                            .padding(8.dp)
                            .background(Color.Gray)
                            .clickable(
                                enabled = true,
                                onClick = { homeBoardViewModel.updateBoard(item) }
                            )
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun Preview() {
    HomeBoardGame()
}