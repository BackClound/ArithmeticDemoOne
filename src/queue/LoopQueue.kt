package queue

class LoopQueue<E>(var capacity: Int): Queue<E>{

    private var data = arrayOfNulls<Any>(capacity) as Array<E?>
    private var front = 0
    private var tail = 0
    private var size = 0

    override fun enqueue(e: E) {
        if ((tail + 1) % capacity == front)
            resize(capacity * 2)

        data[tail] = e
        tail = (tail + 1) % capacity
        size++
    }

    fun resize(newCapacity: Int) {
        if (newCapacity < 0)
            throw Exception(" 新数组长度不对啊！！！")

        val newData = arrayOfNulls<Any>(newCapacity + 1) as Array<E?>
        for (i in 0 until size) {
            newData[i] = data[(i + front) % capacity]
        }
        capacity = newCapacity
        data = newData
        front = 0
        tail = size
    }

    override fun dequeue(): E? {
        if (isEmpty())
            throw Exception("this is an empty collection")
        val ret = data[front]
        data[front] = null
        front = (front + 1) % capacity
        size --
        if (size <= capacity /4 && capacity/2 != 0){
            resize(capacity / 2)
        }

        return ret
    }

    override fun getFront(): E? {
        if (isEmpty())
            throw Exception(" this is an empty collection")

        return data[front]
    }

    override fun getSize(): Int {
        return size
    }


    override fun isEmpty(): Boolean {
        return front == tail
    }

    override fun toString(): String {
        val value = StringBuilder()
        value.append("LoopQueue : size = $size capacity = ${capacity} \n")
        value.append("[ ")
        var i = front
        while (i != tail) {
            value.append(data[i])
            if ((i + 1)%capacity != tail)
                value.append(",")
            i = (i + 1) % capacity
        }
        value.append("] tail")
        return value.toString()
    }
}