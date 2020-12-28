package queue

interface Queue<E> {

    fun enqueue(e: E)

    fun dequeue(): E?

    fun getFront(): E?

    fun getSize(): Int

    fun isEmpty(): Boolean
}