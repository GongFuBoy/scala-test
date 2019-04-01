package com.github.gongfuboy.scalatest.scala

import java.math.RoundingMode
import java.text.{DateFormat, DecimalFormat, SimpleDateFormat}
import java.util.Date

/**
  * Created by ZhouLiMing on 2019/1/29.
  */
object TupleListTest {

  def main(args: Array[String]): Unit = {
//    (0 to 10).sliding(3, 3).toList.foreach(println(_))
//
//    1 match {
//      case 1 => println("1")
//      case 2 => println("2")
//      case _ => println("_")
//    }
//    val date = new Date(1551336993000L)
//    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//    println(format.format(date))
//    val value = "  "
//    println(value.size)
//    println(value.trim.size)

    
    val decimal = BigDecimal.valueOf(10000.652)
    println(new DecimalFormat(",###").format(decimal))

    val decimal1 = BigDecimal.valueOf(1.026)
    println(new DecimalFormat("0.00").format(decimal1))
    new DecimalFormat("#.##%")
    println(new DecimalFormat("#%").format(decimal1))

  }

}