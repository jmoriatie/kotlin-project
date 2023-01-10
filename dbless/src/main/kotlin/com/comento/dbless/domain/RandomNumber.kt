package com.comento.dbless.domain

import java.util.IllegalFormatException
import kotlin.random.Random

class RandomNumber(private val range: String) {

    fun getRandomNum() : String{
        val numbers = range.split("~")
        val minStr = numbers[0]
        val maxStr = numbers[1]

        return try{
            when((minStr.contains(".") || maxStr.contains("."))){ // 더블인지 확인
                true ->  this.getRandomDoubleToString(minStr.toDouble(), maxStr.toDouble(), this.doubleLength(minStr, maxStr) ) // Double 랜덤숫자, 소숫점 짜르기
                false ->  this.getRandomIntToString(minStr.toInt(), maxStr.toInt()) // Int 랜덤숫자
            }
        }catch (e: Exception){
            throw IllegalArgumentException("맞지 않는 메서드", e)
        }
    }

    companion object{
        fun create(range: String): RandomNumber = RandomNumber(range)
    }

    /**
     * 랜덤 double
     */
    private fun getRandomDoubleToString(min : Double, max : Double, doubleLength: Int) : String{
        return String.format("%.${doubleLength}f", Random.nextDouble(min, max))
    }

    /**
     * 랜덤 int
     */
    private fun getRandomIntToString(min : Int, max : Int) : String{
        return Random.nextInt(min, max).toString()
    }

    /**
     * 소숫점 아래 길이 반환
     */
    private fun doubleLength(minStr : String, maxStr : String) : Int{
        // String Extension function 으로 작성 String
        return when(minStr.splitLength() > maxStr.splitLength()) {
            true -> minStr.splitLength()
            false -> maxStr.splitLength()
        }
    }

    /**
     * split 한 소수점 아래 부분 길이 반환
     */
    private fun String.splitLength(): Int = this.split(".")[1].length
}
