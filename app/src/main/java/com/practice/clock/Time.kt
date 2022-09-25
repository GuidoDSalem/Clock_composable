package com.practice.clock

import kotlin.math.PI

class Time(s:Float,m:Float,h:Float) {
    var sec: Float = s
    var min: Float = m
    var hour: Float = h

    fun updateTime(){
        sec ++
        if(sec >= 60){
            sec = 0f
            min++
        }
        if(min >= 60){
            min = 0f
            hour ++
        }
        if(hour >= 12){
            hour = 0f
        }
    }
    fun getSecAngle(): Float{
        return (-90f + sec * (360f / 60f)) * PI.toFloat() / 180f
    }
    fun getMinAngle(): Float{
        return (-90f + min * (360f / 60f)) * PI.toFloat() / 180f
    }
    fun getHourAngle(): Float{
        return (-90f + hour * (360f / 12f)) * PI.toFloat() / 180f
    }

    companion object{

        fun getTrueAngleFromPos(i: Int):Float {
            return (90 - i * (360f / 60f)) * PI.toFloat() / 180f
        }
    }

}