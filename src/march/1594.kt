package march

class Solution {
    fun maxProductPath(grid: Array<IntArray>): Int {
        val MOD = 1_000_000_007
        val m = grid.size
        val n = grid[0].size

        val maxDp = Array(m) { LongArray(n) }
        val minDp = Array(m) { LongArray(n) }

        maxDp[0][0] = grid[0][0].toLong()
        minDp[0][0] = grid[0][0].toLong()

        for (j in 1 until n) {
            val value = grid[0][j].toLong()
            maxDp[0][j] = maxDp[0][j - 1] * value
            minDp[0][j] = maxDp[0][j]
        }

        for (i in 1 until m) {
            val value = grid[i][0].toLong()
            maxDp[i][0] = maxDp[i - 1][0] * value
            minDp[i][0] = maxDp[i][0]
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                val value = grid[i][j].toLong()

                val candidates = listOf(
                    maxDp[i - 1][j],
                    maxDp[i][j - 1],
                    minDp[i - 1][j],
                    minDp[i][j - 1]
                )

                val maxVal = candidates.maxOrNull()!!
                val minVal = candidates.minOrNull()!!

                if (value >= 0) {
                    maxDp[i][j] = maxVal * value
                    minDp[i][j] = minVal * value
                } else {
                    maxDp[i][j] = minVal * value
                    minDp[i][j] = maxVal * value
                }
            }
        }

        val result = maxDp[m - 1][n - 1]
        return if (result < 0) -1 else (result % MOD).toInt()
    }
}