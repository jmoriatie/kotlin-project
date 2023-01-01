package com.comento.dbless.service

import kotlin.random.Random

class CalculatorService {

    fun getRandomNum(range : String) : String{
        val numbers = range.split("~")
        val minStr = numbers[0]
        val maxStr = numbers[1]

        val isDouble = (minStr.contains(".") || maxStr.contains(".")) // 더블인지 확인
        val doubleLength = if(isDouble) this.doubleLength(minStr, maxStr) else TODO()  // 소수점 아래 길이

        val randomNum = when{
            isDouble -> String.format("%.${doubleLength}f", this.getRandomDouble(minStr.toDouble(), maxStr.toDouble())) // Double 랜덤숫자, 소숫점 짜르기
            else -> this.getRandomInt(minStr.toInt(), maxStr.toInt()).toString() // Int 랜덤숫자
        }
        return randomNum
    }

    /**
     * 랜덤 double
     */
    private fun getRandomDouble(min : Double, max : Double) : Double{
        return Random.nextDouble(min, max)
    }

    /**
     * 랜덤 int
     */
    private fun getRandomInt(min : Int, max : Int) : Int{
        return Random.nextInt(min, max)
    }

    /**
     * 소숫점 아래 길이 반환
     */
    private fun doubleLength(minStr : String, maxStr : String) : Int{
       // TODO : String Extension function 으로 작성 String
        return when{
            minStr.contains(".") ->  minStr.split(".")[1].length
            maxStr.contains(".") -> maxStr.split(".")[1].length
            else -> if(minStr.split(".")[1].length > maxStr.split(".")[1].length)
                minStr.split(".")[1].length
            else maxStr.split(".")[1].length
        }
    }
}
