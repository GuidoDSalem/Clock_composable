package com.practice.clock


import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.nativeCanvas
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Clock(
    style:ClockStyle = ClockStyle(),
    initialSecond: Float = 0f,
    initialMinute: Float = 30f,
    initialHour: Float = 2f,
){

    var time by remember{
        mutableStateOf(Time(initialSecond,initialMinute,initialHour))
    }


    Canvas(modifier = Modifier
        .fillMaxSize()
        .aspectRatio(1f)){


        drawContext.canvas.nativeCanvas.apply {
            this.drawCircle(
                center.x,
                center.y,
                style.radius,
                Paint().apply {
                    setShadowLayer(60f,0f,0f,android.graphics.Color.argb(50,0,0,0))
                    this.color = android.graphics.Color.WHITE
                }

            )
        }
        // Borders Lines
        for(i in (0..(5*12))){

            val lineType = when{
                i%5 == 0 -> LineType.FiveLine
                else -> LineType.SimpleLine
            }
            val lineColor = when(lineType){
                LineType.FiveLine -> style.fivesLineColor
                else -> style.simpleLineColor
            }
            val lineLength = when(lineType){
                LineType.FiveLine -> style.fivesLineLength
                else -> style.simpleLineLength
            }
            val lineStroke = when(lineType){
                LineType.FiveLine -> style.fivesLineStroke
                else -> style.simpleLineStroke
            }
            val r = style.radius
            val lx0 = center.x + r * cos(Time.getTrueAngleFromPos(i))
            val ly0 = center.y + r * sin(Time.getTrueAngleFromPos(i))
            val lx1 = center.x + (r - lineLength) * cos(Time.getTrueAngleFromPos(i))
            val ly1 = center.y + (r - lineLength) * sin(Time.getTrueAngleFromPos(i))
            drawLine(
                color = lineColor,
                Offset(lx0,ly0),
                Offset(lx1,ly1),
                strokeWidth = lineStroke.toPx()
            )
        }
        // secondsLine
        drawLine(
            style.secondsLineColor,
            Offset(
                x = center.x,
                y = center.y
            ),
            Offset(
                x = center.x + style.secondsLineLength * cos(Time.getTrueAngleFromPos(initialSecond.toInt())),
                y = center.y - style.secondsLineLength * sin(Time.getTrueAngleFromPos(initialSecond.toInt()))
            ),
            strokeWidth = style.secondsLineStroke.toPx()
        )
        //Minute Line
        drawLine(
            style.minuteLineColor,
            Offset(
                x = center.x,
                y = center.y
            ),
            Offset(
                x = center.x + style.minuteLineLength * cos(Time.getTrueAngleFromPos(initialMinute.toInt())),
                y = center.y - style.minuteLineLength * sin(Time.getTrueAngleFromPos(initialMinute.toInt()))
            ),
            strokeWidth = style.minuteLineStroke.toPx()
        )
        //Hours Line
        drawLine(
            style.hourLineColor,
            Offset(
                x = center.x,
                y = center.y
            ),
            Offset(
                x = center.x + style.hourLineLength * cos(Time.getTrueAngleFromPos(initialHour.toInt())),
                y = center.y - style.hourLineLength * sin(Time.getTrueAngleFromPos(initialHour.toInt()))
            ),
            strokeWidth = style.hourLineStroke.toPx()
        )


    }

}

