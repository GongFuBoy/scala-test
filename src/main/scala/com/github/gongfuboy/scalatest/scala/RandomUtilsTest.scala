package com.github.gongfuboy.scalatest.scala

import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils

/**
  * Created by ZhouLiMing on 2019/1/9.
  */
object RandomUtilsTest {

  def main(args: Array[String]): Unit = {

    for (x <- 20190301 to 20190327) {
      println(x)
    }

    println(List(1, 2, 3).sliding(2).toList)
    println(List(1, 2, 3).inits.toList.filter(!_.isEmpty).reverse)
    println(List(1, 4, 3, 1).groupBy(x => x).toList.sortBy(_._1))

    println(List(Temp(1, 1, 1), Temp(2, 2, 2), Temp(3, 3, 3)).sortWith({
      case (before, after) => {
        if (before.i1 != after.i1) before.i1.hashCode() > after.i1.hashCode()
        else if (before.i2 != after.i2) before.i2.hashCode() > after.i2.hashCode()
        else if (before.i3 != after.i3) before.i3.hashCode() > after.i3.hashCode()
        else false
      }
    }))
  }
}

case class Temp (i1: Int, i2: Int, i3: Int)