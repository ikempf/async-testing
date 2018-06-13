# Blocking (Await.result)

### BlockingSequential
All tests of the SAME suite are run sequentially.\
This approach causes blocking but probably won't cause thread starvation since Await.result uses scala.concurrent.blocking.\
Fixture sharing IS NOT an issue.

### BlockingParallel
All tests are run concurrently.\
This approach causes blocking but probably won't cause thread starvation since Await.result uses scala.concurrent.blocking.\
The number of threads used is higher than the sequential version. In this example (10) threads are used to run the tests concurrently. But more threads are created through the default ExecutionContext.\
Fixture sharing IS an issue. 



# Non blocking (Using scalatest's AsyncXSpec) 

### NonBlockingParallelSingleThreaded
Even though the setup should cause concurrency issues, scalatest's default ExecutionContext effectively runs tests sequentially.\
Does not block (uses few threads).\
Fixture sharing IS NOT an issue.

### NonBlockingParallelMultiThreaded
Overriding scalatest's default execution context to allow async tests to be dispatched and executed concurrently.\
Does not block (uses few threads).\
Fixture sharing IS an issue.

### NonBlockingSequentialMultiThreaded
Does not block (uses few threads).\
Fixture sharing IS NOT an issue.