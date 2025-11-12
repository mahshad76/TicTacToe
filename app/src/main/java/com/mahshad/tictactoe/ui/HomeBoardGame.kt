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

@Composable
fun HomeBoardGame(homeBoardViewModel: HomeBoardViewModel = hiltViewModel(),
    modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        repeat(3) {
            Row() {
                repeat(3) {
                    Text(
                        "click",
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .size(50.dp)
                            .padding(8.dp)
                            .background(Color.Gray)
                            .clickable(
                                enabled = true,
                                onClickLabel = "",
                                onClick = { }
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