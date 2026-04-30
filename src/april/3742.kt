package april

class Solution3742 {
    fun maxPathScore(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size

        val dp = Array(m) {
            Array(n) {
                IntArray(k + 1) { Int.MIN_VALUE }
            }
        }

        dp[0][0][0] = 0

        for (i in 0 until m) {
            for (j in 0 until n) {
                for (c in 0..k) {
                    if (dp[i][j][c] == Int.MIN_VALUE) continue

                    if (i + 1 < m) {
                        val value = grid[i + 1][j]
                        val cost = if (value == 0) 0 else 1
                        if (c + cost <= k) {
                            dp[i + 1][j][c + cost] = maxOf(
                                dp[i + 1][j][c + cost],
                                dp[i][j][c] + value
                            )
                        }
                    }

                    if (j + 1 < n) {
                        val value = grid[i][j + 1]
                        val cost = if (value == 0) 0 else 1
                        if (c + cost <= k) {
                            dp[i][j + 1][c + cost] = maxOf(
                                dp[i][j + 1][c + cost],
                                dp[i][j][c] + value
                            )
                        }
                    }
                }
            }
        }

        var ans = Int.MIN_VALUE
        for (c in 0..k) {
            ans = maxOf(ans, dp[m - 1][n - 1][c])
        }

        return if (ans < 0) -1 else ans
    }
}