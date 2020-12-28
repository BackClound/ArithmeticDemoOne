package stack

interface Stack<E> {
    fun push(item: E)
    fun pop(): E?
    fun peek(): E?
    fun getSize(): Int

    fun isEmpty(): Boolean
}