package node

class ListNode<E>(var data: E? = null) {
    private var size : Int =0
    var next :ListNode<E>? = null

    fun newInstance(array: Array<E>): ListNode<E>? {
        if (array.isNotEmpty()) {
            data = array[0]
            var cur = this
            for (i in 1 until array.size) {
                cur.next = ListNode(array[i])
                cur.next?.let {
                    cur = it
                }
            }
        }
        return this
    }

    override fun toString(): String {
        val res = StringBuilder()
        res.append("ListNode [ \n")
        var cur : ListNode<E>? = this
        while (cur != null) {
            res.append(" ${cur.data} -> ")
            cur = cur.next
        }
        res.append("Null")

        return res.toString()
    }
}