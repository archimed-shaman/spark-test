package com.semrush.data

import java.util.Date

case class event(
  val server_stamp: Date,
  val client_stamp: Date,
  val url: String,
  val domain: String,
  val referer: Option[String],
  val referer_domain: Option[String],
  val status_code: Int,
  val country_code: String,
  val browser: String,
  val operating_system: String,
  val uid: String, // user Id
  val sid: String // session Id
) extends Serializable

object event {
  def makeSid(uid: String, domain: String, startStamp: java.util.Date): String = startStamp.getTime.toString + (uid, domain).hashCode
}
