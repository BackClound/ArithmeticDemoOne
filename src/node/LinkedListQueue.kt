package node

import java.lang.Exception

class LinkedListQueue {

    private var head: Node<Int>? = null
    private var tail :Node<Int>? = null
    var size = 0

    fun isEmpty (): Boolean {
        return size == 0
    }

    fun enqueue(e : Int) {
        if (tail == null) {
            tail = Node(e)
            head = tail
        } else {
            val desNode = Node(e)
            tail?.next = desNode
            tail = desNode
        }
        size++
    }

    fun dequeue():Node<Int>? {
        if (isEmpty()) {
            throw Exception("can not remove anything from an empty collection")
        }

        val retNode = head
        head = retNode?.next
        retNode?.next = null

        if (head == null)
            tail = null
        size--
        return retNode
    }

    fun getFront():Node<Int>? {
        if (isEmpty()) {
            throw Exception("this is an empty collection")
        }

        return head
    }

}