package com.github.gongfuboy.scalatest.scala

/**
  * Created by ZhouLiMing on 2019/1/28.
  */
object IntMatchCase {

  def main(args: Array[String]): Unit = {
    1 match {
      case 1 => println("1")
      case 2 => println("2")
      case _ =>
    }

    2 match {
      case 1 => println("1")
      case 2 => println("2")
      case _ =>
    }
  }

}