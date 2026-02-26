package february

class Solution1404 {
    fun numSteps(s: String): Int {

        val arr: MutableList<Char> = s.map { i -> i }.toMutableList()
        var steps: Int = 0

        while (arr.size != 1) {
            if (arr.last() == '0') arr.removeLast()
            else addOne(arr)
            steps++
        }
        return steps
    }

    fun addOne(arr: MutableList<Char>) {
        val l = arr.size

        for (i in (l - 1) downTo 0) {
            if (arr[i] == '0') {
                arr[i] = '1'
                break
            } else arr[i] = '0'
        }

        if (arr[0] == '0') arr.add(0, '1')
    }
}