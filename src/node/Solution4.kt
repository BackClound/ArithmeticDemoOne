package node

class Solution4 {

    fun <E> reverseList(node: ListNode<E>?): ListNode<E>? {

        var pre: ListNode<E>? = null
        var cur: ListNode<E>? = node
        var next: ListNode<E>? = null

        while (cur != null) {
            next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
        return pre
    }

    fun <E> reverseList2(cur: ListNode<E>?, next: ListNode<E>?): ListNode<E>? {

        if (next == null) {
            return cur
        }
        val res = reverseList2(next, next.next)
        cur?.next = null
        next.next = cur
        return res
    }

}

fun main() {
    val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val head = ListNode<Int>().newInstance(array)
    println(head)

    val res = Solution4().reverseList2<Int>(head, head?.next)
    println(res)
}