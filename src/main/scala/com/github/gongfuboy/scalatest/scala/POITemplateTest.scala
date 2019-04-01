package com.github.gongfuboy.scalatest.scala

import java.io.{FileInputStream, FileOutputStream}

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.poifs.filesystem.POIFSFileSystem


/**
  * Created by ZhouLiMing on 2019/4/1.
  */
object POITemplateTest {

  def main(args: Array[String]): Unit = {
    val fileInputStream = new FileInputStream("d:\\运营日报-汇总信息-模板.xls")
    val hSSFWorkbook = new HSSFWorkbook(new POIFSFileSystem(fileInputStream))
    val sheet1 = hSSFWorkbook.getSheet("Sheet1")
    val cell = sheet1.getRow(0).getCell(7)
    println(cell.getStringCellValue)
    cell.setCellValue("3月29号-修改后")
    hSSFWorkbook.write(new FileOutputStream("d:\\运营日报-汇总信息.xls"))
  }

}