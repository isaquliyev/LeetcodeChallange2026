package march

class Solution3212 {
    fun numberOfSubmatrices(grid: Array<CharArray>): Int {
        val n = grid.size
        val m = grid[0].size
        var ans = 0
        val sum = Array(n + 1) { Array(m + 1) { IntArray(2) } }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] == 'X') {
                    sum[i + 1][j + 1][0] =
                        sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0] + 1
                    sum[i + 1][j + 1][1] = 1
                } else if (grid[i][j] == 'Y') {
                    sum[i + 1][j + 1][0] =
                        sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0] - 1
                    sum[i + 1][j + 1][1] = sum[i + 1][j][1] or sum[i][j + 1][1]
                } else {
                    sum[i + 1][j + 1][0] =
                        sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0]
                    sum[i + 1][j + 1][1] = sum[i + 1][j][1] or sum[i][j + 1][1]
                }

                if (sum[i + 1][j + 1][0] == 0 && sum[i + 1][j + 1][1] == 1) {
                    ans++
                }
            }
        }

        return ans
    }
}