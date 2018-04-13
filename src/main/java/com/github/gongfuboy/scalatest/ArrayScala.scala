package com.github.gongfuboy.scalatest

import Array.concat
import Array.range

/**
  *
  * @author GongFuBoy
  * @date 2018/4/13
  * @time 14:16
  */
object ArrayScala {

  /**
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    // 声明一维数组
    val array = Array("hello", "world", "scala")
    for (temp <- array) {
      println(temp)
    }
    // 声明一维数组
    val array1 = new Array[String](3)
    array1(1) = "String"
    array1(2) = "Temp"
    array1(0) = "World"
    println(array1.length)
    // 合并数组
    val concatArray = concat(array, array1)
    for (temp <- concatArray) {
      println(temp)
    }
    // 范围创建一个数组
    val rangeArray = range(10, 20)
    for (temp <- rangeArray) {
      println(temp)
    }
  }

}