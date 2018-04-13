package com.github.gongfuboy.scalatest

/**
  *
  * @author GongFuBoy
  * @date 2018/4/13
  * @time 14:58
  */
object CollectionScala {

  def main(args: Array[String]): Unit = {
//    listDefine()
    setDefine()
  }


  /**
    * 定义list（链表）
    */
  def listDefine() : Unit = {
    val stringList: List[String] = List("hello", "world", "scala")
    println(stringList.length)
    val changedList = stringList :: "String" :: Nil
    println(changedList.length)
    val intList : List[Int] = 1 :: 2 :: 3 :: 4 :: Nil
    println(intList.length)
    val doubleList = (1 :: 2 :: 3 :: Nil) :: (1 :: 2 :: 3 :: Nil) :: (1 :: 2 :: 3 :: Nil) :: Nil
    for (x <- doubleList) {
      for (y <- x) {
        println(y)
      }
    }
  }

  /**
    * 定义set（不重复集合）
    */
  def setDefine() = {
    val stringSet: Set[String] = Set("hello", "world", "scala")
    val tempStringSet = Set("hello", "temp", "temp1")
    var resultSet = stringSet ++ tempStringSet
    resultSet -= "temp"
    for (temp <- resultSet) {
      println(temp)
    }
  }

}