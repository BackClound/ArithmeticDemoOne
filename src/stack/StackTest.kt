package stack

import Solution

fun main () {
//    val arrayStack = ArrayStack<Int>()
//    for (i in 0..4) {
//
//    }

    val data = ArrayStack<Char>(20)
    val result = Solution().isValid("{([][{()}]{()([])})}")
    System.out.println(" result is $result")
}