package com.practice.clock

sealed class LineType{
    object SimpleLine: LineType()
    object FiveLine: LineType()
    object SecondLine: LineType()
    object MinuteLine: LineType()
    object HourLine: LineType()
}
