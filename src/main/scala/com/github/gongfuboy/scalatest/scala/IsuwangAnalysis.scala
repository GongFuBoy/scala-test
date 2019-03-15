package com.github.gongfuboy.scalatest.scala

import org.ansj.domain.{Result, Term}
import org.ansj.splitWord.analysis.DicAnalysis
import com.isuwang.commons.converters.Implicits._

import scala.collection.JavaConversions._


object IsuwangAnalysis {

  private lazy val CLASS_WORD = List("S", "WCM", "WC", "WM", "MC", "W", "M", "C", "DP", "D", "P", "H", "A", "T", "F", "RK", "LK", "K", "L", "Z")
  private lazy val NEED_FILTER_CLASS_WORD = List("LK", "RK", "Z")
  private lazy val TRANSLATE_WORD = List("库", "出", "港")

  def findWordsByQqMessage(qqMessage: String): (List[Word], String) = {
    val dealtMessage = messageDealing(qqMessage)
    val result: Result = DicAnalysis.parse(dealtMessage)
    val terms: List[Term] = result.getTerms.toList.filter(x => x.getNatureStr in CLASS_WORD)
    val dealtInBracketTerms = removeDesignationInBracket(terms)
    val confirmSupplierTerms = confirmSupplierWord(dealtInBracketTerms.filterNot(x => x.getNatureStr in NEED_FILTER_CLASS_WORD))
    val words = confirmSupplierTerms.map(x => Word(x.getNatureStr, x.getName))
    (words, qqMessage)
  }

  //qq消息解析前处理
  private def messageDealing(message: String): String = {
    message.stripMargin.replaceAll("[\\n\\r]", " 换行符 ") //提取换行符
      .toLowerCase
  }

  private def removeDesignationInBracket(list: List[Term]) = {
    val deleteIndexs = list.zipWithIndex.filter(x => "D".equals(x._1.getNatureStr) || "DP".equals(x._1.getNatureStr))
      .map(_._2)
    val ints = deleteIndexs.map(deleteIndex => {
      val (head, tail) = list.splitAt(deleteIndex)
      val headSum = head.map(x => {
        x.getNatureStr match {
          case "LK" => 1
          case "RK" => -1
          case _ => 0
        }
      }).sum
      val tailSum = tail.map(x => {
        x.getNatureStr match {
          case "LK" => 1
          case "RK" => -1
          case _ => 0
        }
      }).sum
      (deleteIndex, headSum + tailSum == 0 && headSum > 0)
    }).filter(_._2 == true).map(_._1)
    list.zipWithIndex.filterNot(x => ints.contains(x._2)).map(_._1)
  }

  /**
    * 确定真实的供应商
    * @param terms
    */
  private def confirmSupplierWord(terms: List[Term]) = {
    assert(terms.size > 0, "无法找到任何词性, 无法解析报价")
    val supplierWordTerms = terms.filter(_.getNatureStr == "S")
    if (supplierWordTerms.size == 1) terms
    else if (supplierWordTerms.size == 0) throw new RuntimeException("无法找到供应商")
    else if (terms.head.getNatureStr == "S") terms.filterNot(_.getNatureStr == "S") ++ List(terms.head)
    else if (terms.last.getNatureStr == "S") terms.filterNot(_.getNatureStr == "S") ++ List(terms.last)
    else throw new RuntimeException("无法找到供应商")
  }

  def main(args: Array[String]): Unit = {
    val s = "中天35B-8800                厂提\n\n中天35B-9120                淄博正本\n\n中天100PC-8900              临沂/淄博/北京\n\n台塑9001-9900               上海\n\n俄罗斯LD20220-8800          上海/常州\n\n新加坡1002AY-9300           上海\n\n阿塞15803-8500              广州象屿\n\n伊朗2004TC00-8500           广州象屿库溶脂4\n\n新加坡1002BU-9300           黄埔\n\n新加坡1002AY-9200           广州\n\n新加坡SP1520-10750          青岛1月13号到港\n\n常州化轻"
    findWordsByQqMessage(s)
  }
}
