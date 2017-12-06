package com.semrush.data

import org.apache.spark.rdd.RDD

object data_processor {
  def apply(rawRDD: RDD[String]): RDD[event] = ???
}
