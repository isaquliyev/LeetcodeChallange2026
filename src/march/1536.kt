package march

class Solution1536 {
    fun minSwaps(grid: Array<IntArray>): Int {
        val n = grid.size
        val trailingZeros = IntArray(n) { row ->
            var count = 0
            for (j in n - 1 downTo 0) {
                if (grid[row][j] == 0) count++ else break
            }
            count
        }

        var swaps = 0
        for (i in 0 until n) {
            val required = n - 1 - i
            var found = -1
            for (j in i until n) {
                if (trailingZeros[j] >= required) { found = j; break }
            }
            if (found == -1) return -1
            for (j in found downTo i + 1) {
                val tmp = trailingZeros[j]
                trailingZeros[j] = trailingZeros[j - 1]
                trailingZeros[j - 1] = tmp
                swaps++
            }
        }
        return swaps
    }
}