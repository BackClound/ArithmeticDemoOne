interface Collection<Element> {

    open fun add(index: Int, e: Element)

    open fun addFirst(e: Element)

    open fun addLast(e :Element)

    open fun remove(index: Int) : Element?

    open fun removeFirst() : Element?

    open fun removeLast() : Element?

    open fun get(index: Int) : Element?

    open fun getSize() : Int
}