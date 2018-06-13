package com.ikempf

import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.{Executors, TimeUnit}

import com.ikempf.Static.i

import scala.concurrent.{Future, Promise}
import scala.util.Random


object Static {
  var i = 0
}

object Common {

  def async(n: Int): Future[Int] = {
    val p = Promise[Int]()

    Executors.newSingleThreadScheduledExecutor().schedule(() => {
      i = n
      Executors.newSingleThreadScheduledExecutor().schedule(() => {
        p.success(i)
      }, randomDelay, MILLISECONDS)
    }, randomDelay, MILLISECONDS)

    p.future
  }


  private def randomDelay =
    new Random().nextInt(2000)

}
