package com.semrush

import org.scalatest.FlatSpec
import data.event
import java.sql.Timestamp

class data_processor_test extends FlatSpec {

  val stringList = List[String](
    """{"server_stamp":1506816287000,"client_stamp":1506816166795,"url":"https://www.kurnik.pl/pilka/","domain":"kurnik.pl","referer":"https://www.kurnik.pl/pilka/","referer_domain":"kurnik.pl","status_code":200,"country_code":"GB","browser":"Chrome","operating_system":"Windows7","id":"5e1d8d214ed4c39ce19f8351963bfa9c"}""",

    """{"server_stamp":1506816311000,"client_stamp":1506816191913,"url":"https://www.panynj.gov/airports/ewr-to-from.html","domain":"panynj.gov","referer":"https://www.google.ca/","referer_domain":"google.ca","status_code":200,"country_code":"CA","browser":"Chrome","operating_system":"Windows8.1","id":"f7ba9b9aacd447ecc0b4d59de22ff76d"}""",

    """{"server_stamp":1506816311000,"client_stamp":1506816167698,"url":"https://www.kurnik.pl/pilka/#102","domain":"kurnik.pl","referer":"https://www.kurnik.pl/pilka/","referer_domain":"kurnik.pl","status_code":200,"country_code":"GB","browser":"Chrome","operating_system":"Windows7","id":"5e1d8d214ed4c39ce19f8351963bfa9c"}""",

    """{"server_stamp":1506816311000,"client_stamp":1506816241800,"url":"https://www.google.ca/search?q=newark+airport+taxi+credit+card","domain":"google.ca","status_code":200,"country_code":"CA","browser":"Chrome","operating_system":"Windows8.1","id":"f7ba9b9aacd447ecc0b4d59de22ff76d"}""",

    """{"server_stamp":1506816311000,"client_stamp":1506816244646,"url":"https://www.google.ca/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&url=https%3A%2F%2Fwww.tripadvisor.ca%2FShowTopic-g46671-i866-k4524223-Credit_card_to_pay_taxi_ride-Newark_New_Jersey.html&usg=AFQjCNGwhsq959fr9_YFYtYLBsAgX7iOHQ","domain":"google.ca","referer":"https://www.google.ca/","referer_domain":"google.ca","status_code":200,"country_code":"CA","browser":"Chrome","operating_system":"Windows8.1","id":"f7ba9b9aacd447ecc0b4d59de22ff76d"}""",

    """{"server_stamp":1506816311000,"client_stamp":1506816245632,"url":"https://www.tripadvisor.ca/ShowTopic-g46671-i866-k4524223-Credit_card_to_pay_taxi_ride-Newark_New_Jersey.html","domain":"tripadvisor.ca","referer":"https://www.google.ca/","referer_domain":"google.ca","status_code":200,"country_code":"CA","browser":"Chrome","operating_system":"Windows8.1","id":"f7ba9b9aacd447ecc0b4d59de22ff76d"}""",

    """{"server_stamp":1506816312000,"client_stamp":1506816172282,"url":"https://www.kurnik.pl/pilka/","domain":"kurnik.pl","referer":"https://google.com/","referer_domain":"google.com","status_code":200,"country_code":"GB","browser":"Chrome","operating_system":"Windows7","id":"5e1d8d214ed4c39ce19f8351963bfa9c"}""",

    """{"server_stamp":1506816313000,"client_stamp":1506816331663,"url":"https://www.kurnik.pl/pilka/","domain":"kurnik.pl","status_code":200,"country_code":"GB","browser":"Chrome","operating_system":"Windows7","id":"5e1d8d214ed4c39ce19f8351963bfa9c"}"""
  )

  val eventList = List[event](
    // *** SESSION ***
    event(
      server_stamp = new Timestamp(1506816287000L),
      client_stamp = new Timestamp(1506816166795L), // take this timestamp as session start
      url = """https://www.kurnik.pl/pilka/""",
      domain = "kurnik.pl",
      referer = Some[String]("""https://www.kurnik.pl/pilka/"""),
      referer_domain = Some[String]("""kurnik.pl"""),
      status_code = 200,
      country_code = "CA",
      browser = "Chrome",
      operating_system = "Windows8.1",
      uid = "5e1d8d214ed4c39ce19f8351963bfa9c",
      sid = data.event.makeSid("5e1d8d214ed4c39ce19f8351963bfa9c", "kurnik.pl", new Timestamp(1506816166795L))
    ),
    event(
      server_stamp = new Timestamp(1506816311000L),
      client_stamp = new Timestamp(1506816167698L), // take this timestamp as session start
      url = """https://www.kurnik.pl/pilka/#102""",
      domain = "kurnik.pl",
      referer = Some[String]("""https://www.kurnik.pl/pilka/"""),
      referer_domain = Some[String]("""kurnik.pl"""),
      status_code = 200,
      country_code = "CA",
      browser = "Chrome",
      operating_system = "Windows8.1",
      uid = "5e1d8d214ed4c39ce19f8351963bfa9c",
      sid = data.event.makeSid("5e1d8d214ed4c39ce19f8351963bfa9c", "kurnik.pl", new Timestamp(1506816166795L))
    ),
    // *** SESSION ***
    event(
      server_stamp = new Timestamp(1506816311000L),
      client_stamp = new Timestamp(1506816191913L),
      url = """https://www.panynj.gov/airports/ewr-to-from.html""",
      domain = "panyj.gov",
      referer = Some[String]("""https://www.google.ca/"""),
      referer_domain = Some[String]("""google.ca"""),
      status_code = 200,
      country_code = "CA",
      browser = "Chrome",
      operating_system = "Windows8.1",
      uid = "f7ba9b9aacd447ecc0b4d59de22ff76d",
      sid = data.event.makeSid("f7ba9b9aacd447ecc0b4d59de22ff76d", "panyj.gov", new Timestamp(1506816191913L))
    ),
    // *** SESSION ***
    event(
      server_stamp = new Timestamp(1506816311000L),
      client_stamp = new Timestamp(1506816241800L), // take this timestamp as session start
      url = """https://www.google.ca/search?q=newark+airport+taxi+credit+card""",
      domain = "google.ca",
      referer = None,
      referer_domain = None,
      status_code = 200,
      country_code = "CA",
      browser = "Chrome",
      operating_system = "Windows8.1",
      uid = "f7ba9b9aacd447ecc0b4d59de22ff76d",
      sid = data.event.makeSid("f7ba9b9aacd447ecc0b4d59de22ff76d", "google.ca", new Timestamp(1506816241800L))
    ),
    event(
      server_stamp = new Timestamp(1506816311000L),
      client_stamp = new Timestamp(1506816244646L),
      url = """https://www.google.ca/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&url=https%3A%2F%2Fwww.tripadvisor.ca%2FShowTopic-g46671-i866-k4524223-Credit_card_to_pay_taxi_ride-Newark_New_Jersey.html&usg=AFQjCNGwhsq959fr9_YFYtYLBsAgX7iOHQ""",
      domain = "google.ca",
      referer = Some[String]("https://www.google.ca/"),
      referer_domain = Some[String]("google.ca"),
      status_code = 200,
      country_code = "CA",
      browser = "Chrome",
      operating_system = "Windows8.1",
      uid = "f7ba9b9aacd447ecc0b4d59de22ff76d",
      sid = data.event.makeSid("f7ba9b9aacd447ecc0b4d59de22ff76d", "google.ca", new Timestamp(1506816241800L))
    ),
    // *** SESSION ***
    event(
      server_stamp = new Timestamp(1506816311000L),
      client_stamp = new Timestamp(1506816245632L),
      url = """https://www.tripadvisor.ca/ShowTopic-g46671-i866-k4524223-Credit_card_to_pay_taxi_ride-Newark_New_Jersey.html""",
      domain = "tripadvisor.ca",
      referer = Some[String]("""https://www.google.ca/"""),
      referer_domain = Some[String]("""google.ca"""),
      status_code = 200,
      country_code = "CA",
      browser = "Chrome",
      operating_system = "Windows8.1",
      uid = "f7ba9b9aacd447ecc0b4d59de22ff76d",
      sid = data.event.makeSid("f7ba9b9aacd447ecc0b4d59de22ff76d", "tripadvisor.ca", new Timestamp(1506816245632L))
    ),
    // *** SESSION ***
    event(
      server_stamp = new Timestamp(1506816312000L),
      client_stamp = new Timestamp(1506816172282L), // take this timestamp as session start
      url = """https://www.kurnik.pl/pilka/""",
      domain = "kurnik.pl",
      referer = Some[String]("""https://google.com/"""),
      referer_domain = Some[String]("""google.com"""),
      status_code = 200,
      country_code = "CA",
      browser = "Chrome",
      operating_system = "Windows8.1",
      uid = "5e1d8d214ed4c39ce19f8351963bfa9c",
      sid = data.event.makeSid("5e1d8d214ed4c39ce19f8351963bfa9c", "kurnik.pl", new Timestamp(1506816172282L))
    ),
    event(
      server_stamp = new Timestamp(1506816313000L),
      client_stamp = new Timestamp(1506816331663L),
      url = """https://www.kurnik.pl/pilka/""",
      domain = "kurnik.pl",
      referer = None,
      referer_domain = None,
      status_code = 200,
      country_code = "CA",
      browser = "Chrome",
      operating_system = "Windows8.1",
      uid = "5e1d8d214ed4c39ce19f8351963bfa9c",
      sid = data.event.makeSid("5e1d8d214ed4c39ce19f8351963bfa9c", "kurnik.pl", new Timestamp(1506816172282L))
    )
  )

  "events" should "be tagged with session id" in {
    val sc = test_suite.sc
    val rawRDD = sc.parallelize(stringList)
    val resultSet: List[data.event] = data.data_processor(rawRDD).collect.toList // <--- IMPLEMENT class/object data.data_processor

    val eventKey = (e: data.event) => (e.sid, e.uid, e.client_stamp, e.url, e.referer)

    assert(eventList.sortBy(eventKey) == resultSet.sortBy(eventKey)) // sort to be sure, that lists are equals
  }

}
