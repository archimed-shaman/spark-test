package com.semrush

import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object test_suite {

  //==================================================================================

  {
    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)
  }

  //==================================================================================

  val conf = new SparkConf().setAppName("scalyzer_test_suite").setMaster("local[*]")
  val sc = new SparkContext(conf)

}
