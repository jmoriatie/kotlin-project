package com.comento.dbless.service

import kotlin.random.Random

class CalculatorService {

    fun getRandomNum(minStr : String, maxStr : String) : String{
        val isDouble = (minStr.contains(".") || maxStr.contains("."))
        val doubleLength = if(isDouble) this.doubleLength(minStr, maxStr) else TODO()

        val randomNum = when{
            isDouble -> String.format("%.${doubleLength}f", this.getRandomDouble(minStr.toDouble(), maxStr.toDouble()))
            else -> this.getRandomInt(minStr.toInt(), maxStr.toInt()).toString()
        }
        return randomNum
    }

    private fun getRandomDouble(min : Double, max : Double) : Double{
        println("double")
        return Random.nextDouble(min, max)
    }

    private fun getRandomInt(min : Int, max : Int) : Int{
        println("Int")
        return Random.nextInt(min, max)
    }

    private fun doubleLength(minStr : String, maxStr : String) : Int{
        return when{
            minStr.contains(".") ->  minStr.split(".")[1].length
            maxStr.contains(".") -> maxStr.split(".")[1].length
            else -> if(minStr.split(".")[1].length > maxStr.split(".")[1].length) minStr.split(".")[1].length else maxStr.split(".")[1].length
        }
    }
}
