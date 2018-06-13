package com.ikempf

import com.ikempf.Common.async
import org.scalatest.{AsyncFlatSpec, Matchers, ParallelTestExecution}

/**
  * Using scalatest's default "SerialExecutionContext" from AsyncFlatSpec.
  * Executes asynchronous tests sequentially => Fixture sharing IS NOT an issue
  */
class NonBlockingParallelSingleThreaded extends AsyncFlatSpec with Matchers with ParallelTestExecution {

  "test1" should "test" in {
    println("test1")
    async(1).map(_  should equal(1))
  }

  "test2" should "test" in {
    println("test2")
    async(2).map(_  should equal(2))
  }

  "test3" should "test" in {
    println("test3")
    async(3).map(_  should equal(3))
  }

  "test4" should "test" in {
    println("test4")
    async(4)map(_ should equal(4))
  }

}
