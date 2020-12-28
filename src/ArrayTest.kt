class ArrayTest {
}

fun main() {

    val arrayCollection = ArrayCollection<Int>(20)
    val arrayCollection2 = ArrayCollection<Int>(20)
    for (i in 0..9) {
        arrayCollection.addLast(i)
        arrayCollection2.addLast(i)

    }

    arrayCollection.add(4, 50)
    arrayCollection2.setData(4, 50)
//
    arrayCollection.add(2, 78)
    arrayCollection2.setData(2, 78)
    System.out.println(arrayCollection)
//    System.out.println(arrayCollection2)
    for (i  in 0..9) {
        if (i%3 == 0) {
            arrayCollection.remove(i)
        }
    }
    System.out.println(arrayCollection)

}