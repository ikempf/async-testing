package com.ikempf

import com.ikempf.Common.async
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Seconds, Span}
import org.scalatest.{FlatSpec, Matchers, ParallelTestExecution}

class BlockingParallel extends FlatSpec with ScalaFutures with Matchers with ParallelTestExecution {

  override implicit def patienceConfig: PatienceConfig = PatienceConfig(Span(30, Seconds), Span(100, Millis))

  "test1" should "test" in {
    println(1)
    async(1).futureValue should equal(1)
  }

  "test2" should "test" in {
    println(2)
    async(2).futureValue should equal(2)
  }

  "test3" should "test" in {
    println(3)
    async(3).futureValue should equal(3)
  }

  "test4" should "test" in {
    println(4)
    async(4).futureValue should equal(4)
  }

}
