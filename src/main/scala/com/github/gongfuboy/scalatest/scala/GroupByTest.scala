package com.github.gongfuboy.scalatest.scala

/**
  * Created by ZhouLiMing on 2019/1/2.
  */
object GroupByTest {

  def main(args: Array[String]): Unit = {
    val groupByTest1 = GroupByTest("1", 18, 60, Some("1"))
    val groupByTest2 = GroupByTest("1", 18, 81, None)
    val groupByTest3 = GroupByTest("1", 20, 82, None)
    val tests = List(groupByTest1, groupByTest2, groupByTest3)
    val tupleToTests = tests.groupBy(x => (x.name, x.temp))
    println(tupleToTests)
  }

}

case class GroupByTest(name: String, age: Int, weight: Double, temp: Option[String])