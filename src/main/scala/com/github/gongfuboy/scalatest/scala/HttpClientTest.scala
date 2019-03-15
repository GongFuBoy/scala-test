package com.github.gongfuboy.scalatest.scala

import java.nio.charset.Charset

import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

/**
  * Created by ZhouLiMing on 2019/1/21.
  */
object HttpClientTest {

  def main(args: Array[String]): Unit = {
    receiveGroupMessage("")
  }

  def receiveGroupMessage(outputString: String): Unit = {
    val CloseableHttpClient = HttpClients.createDefault
    val post = new HttpPost("http://localhost:8080/index/get")
    post.setHeader("User-Agent", "kuQ-web-client")
    post.setHeader("host", "localhost")
    post.setHeader("Accept", "application/json")
    post.addHeader("Content-type", "application/json; charset=utf-8")
    post.setEntity(new StringEntity("", ""))
    val response = CloseableHttpClient.execute(post)
    try
      EntityUtils.consume(response.getEntity)
    finally {
      response.close()
      CloseableHttpClient.close()
    }
    System.out.println("发送消息成功")
  }

}