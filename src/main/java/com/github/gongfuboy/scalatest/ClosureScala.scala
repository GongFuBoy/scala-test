package com.github.gongfuboy.scalatest

/**
  *
  * @author GongFuBoy
  * @date 2018/4/13
  * @time 13:58
  */
object ClosureScala {

  def main(args: Array[String]): Unit = {
    println(closureScala(2))
  }

  val temp : Int = 1
  var closureScala = (i : Int) => temp * i
}