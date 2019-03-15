package com.github.gongfuboy.scalatest.scala


/**
  * Created by ZhouLiMing on 2019/3/1.
  */
object GroupTest {

  def main(args: Array[String]): Unit = {
    println("12".matches("^[A-Za-z0-9]+$"))
  }

}

case class Person (className: String, personName: String)