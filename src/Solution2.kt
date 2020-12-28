import node.ListNode

class Solution2 {

    fun <E> removeElement(head: ListNode<E>?, item: E):ListNode<E>? {
        val dummyHead = ListNode<E>()
        dummyHead.next = head
        var prev : ListNode<E>? = dummyHead
        while (prev?.next != null) {
            if (prev.next?.data?.equals(item) == true) {
                prev.next = prev.next?.next
            } else {
                prev = prev.next
            }
        }
        return dummyHead.next
    }

}

fun main() {
    val array = arrayOf(1,2,3,4,5,6)

    val head = ListNode<Int>().newInstance(array)

    println(head)
    val res = Solution2().removeElement<Int>(head, 4)
    println(res)

    val res1 = Solution2().removeElement<Int>(head, 2)
    println(res1)

    val res2 = Solution2().removeElement<Int>(head, 6)
    println(res2)
}