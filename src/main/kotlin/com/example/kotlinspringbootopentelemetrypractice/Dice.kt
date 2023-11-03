package com.example.kotlinspringbootopentelemetrypractice

class Dice(val min: Int, val max: Int) {
    fun rollTheDice(rolls: Int): List<Int> {
        return List(rolls) { (min..max).random() }
    }
}
