package april

class Solution3225 {
    fun maximumScore(grid: Array<IntArray>): Long {
        val n = grid[0].size
        if (n == 1) return 0L

        val dp = Array(n) { Array(n + 1) { LongArray(n + 1) } }
        val prevMax = Array(n + 1) { LongArray(n + 1) }
        val prevSuffixMax = Array(n + 1) { LongArray(n + 1) }
        val colSum = Array(n) { LongArray(n + 1) }

        // Build prefix sums for each column
        for (c in 0 until n) {
            for (r in 1..n) {
                colSum[c][r] = colSum[c][r - 1] + grid[r - 1][c]
            }
        }

        for (i in 1 until n) {
            for (currH in 0..n) {
                for (prevH in 0..n) {
                    if (currH <= prevH) {
                        val extraScore = colSum[i][prevH] - colSum[i][currH]
                        dp[i][currH][prevH] = maxOf(
                            dp[i][currH][prevH],
                            prevSuffixMax[prevH][0] + extraScore
                        )
                    } else {
                        val extraScore = colSum[i - 1][currH] - colSum[i - 1][prevH]
                        dp[i][currH][prevH] = maxOf(
                            dp[i][currH][prevH],
                            maxOf(
                                prevSuffixMax[prevH][currH],
                                prevMax[prevH][currH] + extraScore
                            )
                        )
                    }
                }
            }

            for (currH in 0..n) {
                prevMax[currH][0] = dp[i][currH][0]
                for (prevH in 1..n) {
                    val penalty = if (prevH > currH)
                        colSum[i][prevH] - colSum[i][currH]
                    else 0L

                    prevMax[currH][prevH] = maxOf(
                        prevMax[currH][prevH - 1],
                        dp[i][currH][prevH] - penalty
                    )
                }

                prevSuffixMax[currH][n] = dp[i][currH][n]
                for (prevH in n - 1 downTo 0) {
                    prevSuffixMax[currH][prevH] = maxOf(
                        prevSuffixMax[currH][prevH + 1],
                        dp[i][currH][prevH]
                    )
                }
            }
        }

        var ans = 0L
        for (k in 0..n) {
            ans = maxOf(ans, maxOf(dp[n - 1][n][k], dp[n - 1][0][k]))
        }

        return ans
    }
}