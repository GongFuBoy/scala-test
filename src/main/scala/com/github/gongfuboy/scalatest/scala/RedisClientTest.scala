package com.github.gongfuboy.scalatest.scala

import redis.clients.jedis.Jedis

import scala.io.Source
import scala.collection.JavaConversions._

/**
  * Created by ZhouLiMing on 2018/12/11.
  */
object RedisClientTest {

  private lazy val QQ_PRICE_LUA_PATH = "/qq_price.lua"
  private lazy val QQ_MESSAGE_REDIS_KEY_SOUTH = "qq_message_keyword_cache_key_1"
  private lazy val QQ_MESSAGE_REDIS_KEY_EAST = "qq_message_keyword_cache_key_2"

  private def lua(luaPath: String) = {
    val lua = for {
      line <- Source.fromInputStream(getClass.getResourceAsStream(luaPath)).getLines
    } yield {
      line
    }
    lua.mkString("\n")
  }


  /**
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_2 1544508411284 1544508411284
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_2 1544508216658 1544508216658
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_2 1544508468592 1544508468592
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_2 1544508012296 1544508012296
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_2 1544508004658 1544508004658
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_2 1544508395198 1544508395198
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_2 1544508180734 1544508180734
    *
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_2 1544508176892 1544508176892
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_2 1544508009269 1544508009269
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_2 1544508290471 1544508290471
    *
    *
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_1 1544508262902 1544508262902
    *
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_1 1544508405274 1544508405274
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_1 1544508218252 1544508218252
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_1 1544508128333 1544508128333
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_1 1544508036401 1544508036401
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_1 1544507914761 1544507914761
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_1 1544507905137 1544507905137
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_1 1544508154090 1544508154090
    * ZREMRANGEBYSCORE qq_message_keyword_cache_key_1 1544508380322 1544508380322
    *
    *
    * ZCOUNT qq_message_keyword_cache_key_1 1544508405274 1544508405274
    * ZCOUNT qq_message_keyword_cache_key_1 1544508218252 1544508218252
    * ZCOUNT qq_message_keyword_cache_key_1 1544508128333 1544508128333
    * ZCOUNT qq_message_keyword_cache_key_1 1544508036401 1544508036401
    * ZCOUNT qq_message_keyword_cache_key_1 1544507914761 1544507914761
    * ZCOUNT qq_message_keyword_cache_key_1 1544507905137 1544507905137
    * ZCOUNT qq_message_keyword_cache_key_1 1544508154090 1544508154090
    * ZCOUNT qq_message_keyword_cache_key_1 1544508380322 1544508380322
    *
    * @param args
    */


  def main(args: Array[String]): Unit = {
    println("17674130318".matches("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$"))
//    val jedis = new Jedis("127.0.0.1", 20002)

//    val value = jedis.eval(lua(QQ_PRICE_LUA_PATH), List(QQ_MESSAGE_REDIS_KEY_EAST), List("周丹娟", "0", "500", "1"))
//    println(value)
  }

}