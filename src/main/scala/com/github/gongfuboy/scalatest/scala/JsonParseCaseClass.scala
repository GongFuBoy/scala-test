package com.github.gongfuboy.scalatest.scala

import java.time.LocalDateTime
import java.util.Date

import org.json4s.DefaultFormats
import org.json4s.ext.JavaTimeSerializers
import org.json4s.native.Serialization.{read, write}


/**
  * Created by ZhouLiMing on 2018/12/25.
  */
object JsonParseCaseClass {
  implicit val formats2 = DefaultFormats.++(JavaTimeSerializers.all)


  def main(args: Array[String]): Unit = {
    val test = Test(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, List(1, 2, 3))
    val str: String = write(test)
    println(str)
    println(read[Test](str))

    val test1 = Test1(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, List(1, 2, 3), new Date, None, LocalDateTime.now())
    val str1: String = write(test1)
    println(str1)
    println(read[Test1](str1))
  }

}
