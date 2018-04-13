package com.github.gongfuboy.scalatest

/**
  *
  * 函数定义的方式
 *
  * @author GongFuBoy
  * @date 2018/4/13
  * @time 9:23
  */
object FunctionTest {

  def main(args: Array[String]): Unit = {
    println(normalFunction(1,2))
    println(normalFunction())
    // 不太明白执行流程
    println(callByNameFunction(normalFunction(1,2)))
    allocateArgsNameFunction(b=1, a=2);
    variableParameterFunction("temp1", "temp2" , "temp3")
    println(recursiveFunction(2))
    println(defautArgsFunction())
    println(higherOrderFunction(recursiveFunction, 10))
    outFunction(1)
    println(lambda)

    // 偏应用函数
    val function = utinilyFunction(_ : Int, new java.util.Date());
    function(1)
    function(2)
    function(3)

    // 函数柯里化
    println(curryingFunction("temp1")("temp2"))
  }

  /**
    * Scala带有参数的普通方法定义
    * @param a
    * @param b
    * @return
    */
  def normalFunction(a : Int, b : Int) : Int = {
    // 首先定义返回值，确定类型
    var sum : Int = 0;
    // 入参两个相加，复制给返回值
    sum = a + b;
    return sum
  }

  /**
    * Scala不带参数的普通方法
    */
  def normalFunction() : Unit = {
    println("这是一个简单方法")
  }

  /**
    * Scala函数传名调用
    * @param a
    */
  def callByNameFunction(a : => Int ) : Unit = {
    println(a);
  }

  /**
    * Scala指定函数参数名调用
    * @param a
    * @param b
    */
  def allocateArgsNameFunction(a : Int, b : Int) : Unit = {
    println("获取到的参数a:" + a + "获取到的参数b:" + b)
  }

  /**
    * Scala可变参数函数调用
    * @param strings
    */
  def variableParameterFunction(strings : String*) : Unit = {
    for (temp <- strings) {
      println(temp)
    }
  }

  /**
    * Scala递归函数调用
    * @param a
    * @return
    */
  def recursiveFunction(a : Int) : Int = {
    if (a <= 1) {
      return a;
    }
    return a * recursiveFunction(a - 1);

  }

  /**
    * Scala默认参数函数调用
    * @param a
    * @param b
    * @return
    */
  def defautArgsFunction(a : Int = 1, b : Int = 2) : Int = {
    return a + b;
  }

  /**
    * Scala高阶函数调用
    * @param f
    * @param v
    * @return
    */
  def higherOrderFunction(f : Int => Int, v : Int) = f(v)

  /**
    * Scala内部函数调用
    * @param i
    */
  def outFunction(i : Int)= {
    def innerFunction (i : Int): Unit = {
      println("inner funciton i = " + i)
    }
    println("out function i = " + i)
    innerFunction(i)
  }

  /**
    * 匿名方法
    */
  val lambda = (i: Int) => i + i

  /**
    * 偏应用函数
    * @param i
    * @param date
    */
  def utinilyFunction(i : Int, date : java.util.Date) : Unit = {
    println(i + "" + date)
  }

  /**
    * 函数柯里化
    * @param temp1
    * @param temp2
    * @return
    */
  def curryingFunction(temp1 : String)(temp2 : String) : String = {
    temp1 + temp2
  }

}