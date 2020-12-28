package queue

import ArrayCollection
import java.lang.StringBuilder

class ArrayQueue<E>(var capacity: Int): Queue<E> {

    val data = ArrayCollection<E>(capacity)
    override fun enqueue(e: E) {
        data.addLast(e)
    }

    override fun dequeue(): E? {
        return data.removeFirst()
    }

    override fun getFront(): E? {
        return data.getFirst()
    }

    override fun getSize(): Int {
        return data.getSize()
    }

    override fun isEmpty(): Boolean {
        return data.isEmpty()
    }

    override fun toString(): String {
        val value = StringBuilder()
        value.append("ArrayQueue : \n")
        value.append("[ ")
        for (i in 0 until data.getSize()) {
            value.append("\t item ${data.get(i)}")
        }
        value.append(" ]")
        return value.toString()
    }
}