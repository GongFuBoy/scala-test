package com.github.gongfuboy.scalatest.scala

import org.ansj.library.DicLibrary
import org.ansj.splitWord.analysis.DicAnalysis
import org.ansj.util.MyStaticValue
import org.apache.commons.lang.StringUtils
import org.nlpcn.commons.lang.tire.library.Library

import scala.collection.JavaConversions._

import scala.io.Source

/**
  * Created by ZhouLiMing on 2018/11/22.
  */
object SqlCreaterTest {

  private val file = Source.fromInputStream(getClass.getResourceAsStream("/company.sql"))

  def main(args: Array[String]): Unit = {
    reload
    val result = DicAnalysis.parse(s)
    val terms = result.getTerms.toList.filter(_.getNatureStr == "S")
    println("-------------------")
  }

  def reload = {
    val forest = Library.makeForest("D:/default.dic")
    DicLibrary.put(DicLibrary.DEFAULT, DicLibrary.DEFAULT, forest)

    MyStaticValue.isNameRecognition = false
    MyStaticValue.isNewWord = false
    MyStaticValue.isNumRecognition = false
    MyStaticValue.isQuantifierRecognition = false
    MyStaticValue.isRealName = false
    MyStaticValue.isSkipUserDefine = false
  }

  private val s = "常州抚顺L5 9350  常化轻"


}