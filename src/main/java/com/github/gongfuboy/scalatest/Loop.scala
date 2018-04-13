package com.github.gongfuboy.scalatest

import java.util

import scala.util.control.Breaks

/**
  * Scala循环的使用方式
  *
  * @author GongFuBoy
  * @date 2018/4/13
  * @time 10:47
  */
object Loop {

  def main(args: Array[String]): Unit = {
    println(whileLoop())
    println(doWhileLoop())
    forLoop()
    forListLoop()
//    loopYieldInCondition()
    breakLoop()
  }

  /**
    * while循环的使用
    * @return
    */
  def whileLoop (): Int = {
    var i = 1
    while (i < 10) {
      i +=i
    }
    i
  }

  /**
    * doWhile循环使用
    * @return
    */
  def doWhileLoop() : Int = {
    var i = 1
    do {
      i += i
    } while (i < 10)
    i
  }

  /**
    * for循环使用
    */
  def forLoop() : Unit = {
    // 这里是双层循环类似
    //    for (int i=0; i<=2; i++) {
    //      for (int j=0; i<2; j++) {
    //        println("i:" + i)
    //        println("j:" + j)
    //      }
    //    }
    for (i <- 0 to 2; j <- 0 until 2) {
      println("i:" + i)
      println("j:" + j)
    }
  }

  /**
    * Scala集合循环遍历
    */
  def forListLoop(): Unit = {
    val strings = List("temp1", "temp2", "temp3")
    for (string <- strings){
      println(string)
    }
  }

  /**
    * Scala集合循环使用Yield
    */
  def loopYieldInCondition() = {
    var a = 0;
    val numList = List(1,2,3,4,5,6,7,8,9,10);

    // for 循环
    val retVal = for{ a <- numList
                      if a != 3; if a < 8
    }yield a

    // 输出返回值
    for( a <- retVal){
      println( "Value of a: " + a );
    }
  }

  def breakLoop() = {

    val breakOut = new Breaks
    val breakIn = new Breaks

    val outList = List(1,2,3)
    val inList = List(4,5,6)

    breakOut.breakable {
      for (a <- outList) {
        if ( a == 3 ) {
          breakOut.break
        }
        println( "Value of a: " + a );

        breakIn.breakable {
          for (b <- inList) {
            if (b == 6) {
              breakIn.break()
            }
            println("Value of b:" + b)
          }
        }
      }

    }

  }



}