package com.practice.clock

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ClockStyle(
    val radius: Float = 200f,
    val secondsLineLength: Float = radius * 0.7f,
    val minuteLineLength: Float = radius * 0.7f,
    val hourLineLength: Float = radius * 0.7f,
    val fivesLineLength: Float = radius * 0.2f,
    val simpleLineLength: Float = radius * 0.15f,

    val secondsLineColor: Color = Color.Red ,
    val minuteLineColor: Color = Color.Black,
    val hourLineColor: Color = Color.Black,
    val fivesLineColor: Color = Color.Black,
    val simpleLineColor: Color = Color.Gray,

    val secondsLineStroke: Dp = 5.dp,
    val minuteLineStroke: Dp = 2.dp,
    val hourLineStroke: Dp = 3.dp,
    val fivesLineStroke: Dp = 2.dp,
    val simpleLineStroke: Dp = 2.dp,
)
