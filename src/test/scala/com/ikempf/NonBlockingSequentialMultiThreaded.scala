package com.ikempf

import com.ikempf.Common.async
import org.scalatest.{AsyncFlatSpec, Matchers}

import scala.concurrent.ExecutionContext


class NonBlockingSequentialMultiThreaded extends AsyncFlatSpec with Matchers {
  implicit override def executionContext: ExecutionContext = ExecutionContext.Implicits.global

  "test1" should "test" in {
    async(1).map(_  should equal(1))
  }

  "test2" should "test" in {
    async(2).map(_  should equal(2))
  }

  "test3" should "test" in {
    async(3).map(_  should equal(3))
  }

  "test4" should "test" in {
    async(4)map(_ should equal(4))
  }

}
