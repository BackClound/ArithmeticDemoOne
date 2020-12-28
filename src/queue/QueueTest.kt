package queue

class QueueTest {
}

fun main() {
    val queue = ArrayQueue<Int>(20)
//    for (i in 0..10) {
//        queue.enqueue(i)
//        println("enqueue : $queue")
//        if (i%3 == 1) {
//            queue.dequeue()
//            println("dequeue : $queue")
//        }
//    }

    val loopQueue = LoopQueue<Int>(10)
    for (i in 0..10) {
        loopQueue.enqueue(i)
        println("enqueue : $loopQueue")
        if (i%3 == 2) {
            loopQueue.dequeue()
            println("dequeue : $loopQueue")
        }
    }
}