package node

import java.lang.Exception

class LinkedListDummy {

    var dummyHead: Node<Int>? = Node(null, null)
    var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun addFirst(e: Int): Node<Int>? {
//        val node  = Node(e, null)
//
//        node.next = dummyHead?.next
//        dummyHead?.next = node
//        size ++

        return add(0, e)

    }

    fun add(index: Int, e: Int): Node<Int>? {
        if (index < 0 || index > size) {
            throw Exception("Out of bounds")
        }
        var pre = dummyHead
        for (i in 0 until index) {
            pre = pre?.next
        }
        val node = Node(e, null)
        node.next = pre?.next
        pre?.next = node
        //pre?.next = Node(e, pre?.next)

        //递归实现
        //addRecursion(dummyHead, index , e)
        size++


        return dummyHead
    }
//在已node为头结点的链表的index位置添加元素e
    fun  addRecursion(node: Node<Int>?, index: Int, e: Int): Node<Int>? {
        if (index == 0) {
            return Node(e, node)
        }

        node?.next = addRecursion(node?.next, index-1, e)

        return node?.next
    }
    fun addLast(e: Int): Node<Int>? {
        return add(size, e)
    }

    //查询Index位置的元素e
    fun get(index: Int): Node<Int>? {
        if (index < 0 || index > size) {
            throw Exception("out of bounds")
        }

        var cur = dummyHead?.next
        for (i in 0 until index) {
            cur = cur?.next
        }

        return cur
    }

    fun getFirst(): Node<Int>? {
        return get(0)
    }

    fun getLast(): Node<Int>? {
        return get(size - 1)
    }

    fun set(index: Int, e: Int) {
        if (index < 0 || index > size) {
            throw Exception("Index out of bounds")
        }
        var cur  = dummyHead?.next
        for (i in 0 until index) {
            cur = cur?.next
        }

        cur?.value = e
    }

    fun contains(e : Int): Boolean {
        var cur = dummyHead?.next
        while (cur != null) {
            if (cur.value?.equals(e) == true) {
                return true
            }
            cur = cur.next
        }
        return false
    }

    fun remove(index: Int) {
        if (index < 0 || index > size) {
            throw Exception("index out of bounds")
        }

        var cur = dummyHead
        for (i in 0 until index) {
            cur = cur?.next
        }
        val delItem = cur?.next
        cur?.next = delItem?.next
        delItem?.next = null
        size--
    }

    fun removeFirst() {
        remove(0)
    }
    fun removeLast() {
        remove(size - 1)
    }

    override fun toString(): String {
        val toString = StringBuilder()
         var cur = dummyHead?.next
        while (cur != null) {
            toString.append("$cur ->")
            cur = cur.next
        }
        toString.append("Null")
        return toString.toString()
    }

    fun initialization(): Node<Int>? {
        var cur: Node<Int>? = null
        dummyHead = Node(-1, null)
        for (i in 0..5) {

            val temp = Node<Int>(i, null)
            cur = cur ?: temp
//            cur = temp
            dummyHead?.next = cur
            cur.next = temp
            cur = cur.next

        }
        return dummyHead
    }
}

fun main() {
    val linkedListDummy = LinkedListDummy()
    for (i in 0 until 5) {
        linkedListDummy.addFirst(i)
        println(linkedListDummy)
    }
    linkedListDummy.add(2, 888)
    println(linkedListDummy)

    linkedListDummy.removeFirst()
    println(linkedListDummy)

    linkedListDummy.removeLast()
    println(linkedListDummy)

    linkedListDummy.remove(2)
    println(linkedListDummy)


}
