import com.sun.org.apache.xpath.internal.operations.Bool
import java.awt.event.FocusEvent

class ArrayCollection<Election>(var capacity: Int) : Collection<Election> {
    //数组中元素的数量
    private var size: Int = 0

//    //数组的容积
//    var capacity : Int = 10

    //    val data = arrayOfNulls<Election>(10)
    private var data: Array<Election?>

    init {
        data = arrayOfNulls<Any>(capacity) as Array<Election?>
    }

    override fun getSize(): Int {
        return size
    }

    //插入数据
    override fun add(index: Int, e: Election) {
        if (size == capacity) {
            resizeArray()
        }

//        if (index in (capacity + 1)..-1 && size > capacity) {
//            throw Exception("Array add failed, index out of bounds")
//        }

        if (index < 0 || index > size) {
            throw Exception("Array add failed, index out of bounds")
        }

//        if (size < capacity && index >= size)
//            data[index] = e

        for (i in size - 1 downTo index step 1) {
            data[i + 1] = data[i]
        }
        data[index] = e
        size++
    }

    //替换元素
    fun setData(index: Int, e: Election) {
        if (index < 0 || index > size - 1) {
            throw java.lang.Exception("Array set feailed, index out of bounds")
        }

        data[index] = e
    }
    //查找数组中是否有元素e
    fun contains(e: Election): Boolean {
        for (i in data.indices) {
            if (data[i] == e) {
                return true
            }
        }
        return false
    }

    //查找元素e所在的位置
    fun find(e: Election) : Int {
        for (i in data.indices) {
            if (data[i] == e) {
                return i
            }
        }
        return -1
    }

    //数组扩容
    private fun resizeArray() {
        if (size == capacity) {
            val newData = arrayOfNulls<Any>(capacity * 2) as Array<Election?>

            for (i in data.indices) {
                newData[i] = data[i]
            }
            capacity *= 2
            data = newData
        }

    }

    /** 添加元素到数组第一位
     * @param e 要添加的元素
     */
    override fun addFirst(e: Election) {
        add(0, e)
    }

    /**
     * 添加元素到数组最后一位
     * @param e 待添加的元素
     */
    override fun addLast(e: Election) {
        add(size, e)
    }

    override fun remove(index: Int): Election? {
        if (index < 0 || index >= size) {
//            return
            throw Exception("remove array failed, index out of bounds. index is $index")
        }

        if (size < capacity / 4) {
            reduceArray()
        }
        val ret = data[index]
        for (i in index + 1 until size step 1) {
            data[i - 1] = data[i]
        }

        size--
        return ret
    }

    private fun reduceArray() {
        if (size <= capacity / 4 && capacity / 2 > 10) {
            val newData = arrayOfNulls<Any>(capacity / 2 + 1) as Array<Election?>
            for (i in 0 until size) {
                newData[i] = data[i]
            }
            data = newData
            capacity /= 2
        }
    }

    override fun removeFirst():Election? {
        return remove(0)
    }

    override fun removeLast(): Election? {
        return remove(size -1)
    }

    //删除某个元素
    fun removeElection(e: Election) {
        val index = find(e)
        if (index != -1) {
            remove(index)
        }
    }

    override fun get(index: Int): Election? {
        if (index < 0 || index >= size) {
            throw java.lang.Exception("query params failed, index out of bounds")
        }

        return data[index]
    }

    fun getLast(): Election? {
        return data[size -1]
    }

    fun getFirst(): Election? {
        return data[0]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        val value = StringBuffer()
        value.append("ArrayCollection \n size is $size and capacity is $capacity \n")
        for (index in 0 until size) {
            value.append("index is $index item is ${data[index]} \n")
        }
        return value.toString()
    }
}