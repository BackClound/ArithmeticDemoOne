package node

import java.lang.Exception

class LinkedList<E> {

    var head: Node<E>? = null
    var size: Int = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun addFirst(e :E) {
        val node = Node<E>(e,null)
        node.next = head
        head = node
        // head = Node(e, head)
        size++
    }

    //在链表的第index个位置添加元素 e
    fun add(index: Int, e :E) {
        if (index < 0 || index > size) {
            throw Exception("out of bounds can not put into LinkedList")
        }
        if (index == 0) {
            addFirst(e)
        } else {
            var pre = head
            for (i in 0 until index -1) {
                pre = pre?.next
            }
            val node = Node(e)
            node.next = pre?.next
            pre?.next = node
            //pre?.next = Node(e, pre?.next)
            size ++

        }
    }

    //在链表末尾添加元素e
    fun addLast(e: E) {
        add(size, e)
    }

    fun removeFirst(): Node<E>? {
        if (head?.next == null) {
            val temp = head
            head = null
            return temp
        }
        val node = head?.next
        val temp = head
        head = node
        return temp

    }


}

fun main() {
    var head: Node<Int>? = null
    var next: Node<Int>? = null
    for (i in 0..4) {
        if (head == null) {
            head = Node<Int>(i, null)
            next = head.next
        } else {
            val temp = Node(i, null)
            if (head.next == null) {
                next = temp
                head.next = next
                continue
            }

            next?.next = temp
            next = next?.next
        }
    }
    println("${head.toString()}")
}

class Node<T>(var value: T?, var next: Node<T>? = null) {

    override fun toString(): String {
//        val tostring = StringBuilder()
//        tostring.append("Node : [ ")
//        var cur: Node<T>? = this
//        while (cur != null) {
//            tostring.append(" ${cur.value} -> ")
//            cur = cur.next
//        }
//
//        tostring.append("  Null")
//        tostring.append(" ]")
//        return tostring.toString()
        return "$value"
    }
}