package com.github.gongfuboy.scalatest.scala

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.commons.lang.time.DateFormatUtils

/**
  * Created by ZhouLiMing on 2019/1/2.
  */
object GroupByTest {

  def main(args: Array[String]): Unit = {
    val format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
    val date: Date = format.parse("2019-03-23 17:53:11")
    println(date.getTime)
  }

}

case class GroupByTest(name: String, age: Int, weight: Double, temp: Option[String])