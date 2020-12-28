import node.ListNode

class Solution3 {

    fun <E> removeElement(head: ListNode<E>?, e : E): ListNode<E>? {
        if (head == null) {
            return null
        }

        head.next = removeElement(head.next, e)
        return if (head.data == e)  head.next else head

//        head.next = removeElement(head.next, e)
//        return if (head.data == e) {
//            head.next
//        } else {
//            head
//        }

//        val res = removeElement(head.next, e)
//        return if (head.data == e) {
//            res
//        } else {
//            head.next = res
//            head
//        }


    }
}

fun main() {
    val array = arrayOf(1,2,3,4,5,6,7,8, 3, 9, 5)
    val head = ListNode<Int>().newInstance(array)
    println(head)

    val res = Solution3().removeElement(head, 7)
    println(res)

    val res1 = Solution3().removeElement(head, 4)
    println(res1)

    val res2 = Solution3().removeElement(head, 3)
    println(res2)

}