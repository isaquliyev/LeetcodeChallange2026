package february

class Solution1356 {
    fun sortByBits(arr: IntArray): IntArray {

        val comparator: Comparator<Int> = Comparator<Int> { o1, o2 ->
            val o1SetBits = o1.countOneBits()
            val o2SetBits = o2.countOneBits()
            if (o1SetBits != o2SetBits) {
                o1SetBits - o2SetBits
            } else {
                o1 - o2
            }
        }

        return arr.sortedWith(comparator).toIntArray()
    }
}