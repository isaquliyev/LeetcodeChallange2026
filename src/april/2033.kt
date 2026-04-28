package april

class Solution2033 {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val numsArray = ArrayList<Int>()
        var result = 0

        for (row in grid.indices) {
            for (col in grid[0].indices) {
                numsArray.add(grid[row][col])
            }
        }

        numsArray.sort()

        val length = numsArray.size
        val finalCommonNumber = numsArray[length / 2]

        for (number in numsArray) {
            if (number % x != finalCommonNumber % x) {
                return -1
            }
            result += Math.abs(finalCommonNumber - number) / x
        }

        return result
    }
}