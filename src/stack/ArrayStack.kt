package stack

import ArrayCollection
import java.lang.StringBuilder

class ArrayStack<E>(var capacity : Int) :  Stack<E>{

    val array : ArrayCollection<E> = ArrayCollection(capacity)

    override fun push(item: E) {
        array.addLast(item)
    }

    override fun pop(): E? {
        return array.removeLast()
    }

    override fun peek(): E? {
        return array.getLast()
    }

    override fun getSize(): Int {
        return array.getSize()
    }

    override fun isEmpty(): Boolean {
        return array.isEmpty()
    }

    override fun toString(): String {
        val logBuild = StringBuilder()
        logBuild.append("ArrayStack size = ${array.getSize()} capacity = $capacity \n")
        logBuild.append("[ \n")
        for (i in 0 until array.getSize()) {
            logBuild.append("\t index = $i item = ${array.get(i)} \n")
        }
        logBuild.append("] \n")

        return logBuild.toString()
    }
}