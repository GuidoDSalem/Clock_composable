package com.practice.clock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.clock.ui.theme.ClockTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClockTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BoxWithConstraints(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        var time by remember{
                            mutableStateOf(Time(0f,45f,2f))
                        }

                        var key by remember{
                            mutableStateOf(0)
                        }
                        LaunchedEffect(key1 = key){
                            delay(1000L)
                            time.updateTime()
                            key = key + 1

                        }
                        Clock(
                            style = ClockStyle(radius = (constraints.maxWidth * 0.8 / 2).toFloat()),
                            initialSecond = time.sec,
                            initialMinute = time.min,
                            initialHour = time.hour
                            )
                        Text(
                            text = time.min.toString(),
                            style = MaterialTheme.typography.h3,
                            color = MaterialTheme.colors.primary,
                        )
//                        Text(
//                            text = key.toString(),
//                            style = MaterialTheme.typography.h3,
//                            color = MaterialTheme.colors.primary,
//                        )

                    }
                }
            }
        }
    }
}

