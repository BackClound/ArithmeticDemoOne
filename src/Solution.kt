import com.sun.javafx.binding.StringFormatter
import stack.ArrayStack

class Solution {

    public fun isValid(source: String): Boolean {

//        val source = "{[{[]}{{{}}}]}"
        val data = ArrayStack<Char>(20)
        for (i in source.indices) {
            when(source[i]) {
                '{' -> {
                    data.push(source[i])
                }
                '[' -> {
                    data.push(source[i])
                }
                ']' -> {
                    if (data.isEmpty()) return false
                    if (data.pop() == '[') {

                    } else {
                        return false
                    }
                }
                '}' -> {
                    if (data.isEmpty()) return false
                    if (data.pop() == '{') {

                    } else {
                        return false
                    }
                }
            }
        }
        return true
    }
}