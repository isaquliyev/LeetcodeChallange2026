class Solution1200 {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()
        val size: Int = arr.size
        val l: MutableList<List<Int>> = mutableListOf()

        var m: Int = Int.MAX_VALUE

        for (i in 1 until size) {
            if(arr[i] - arr[i - 1] < m) {
                m = arr[i] - arr[i - 1]
                l.clear()
            }

            if (arr[i] - arr[i - 1] == m) {
                l.add(listOf(arr[i - 1], arr[i]))
            }
        }

        return l.toList()
    }
}