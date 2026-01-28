class Solution3651 {
    fun minCost(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size

        val points = buildList {
            for (i in 0 until m)
                for (j in 0 until n)
                    add(i to j)
        }.sortedBy { (i, j) -> grid[i][j] }

        val costs = Array(m) { IntArray(n) { Int.MAX_VALUE } }

        repeat(k + 1) {
            var minCost = Int.MAX_VALUE
            var start = 0

            for (i in points.indices) {
                val (x, y) = points[i]
                minCost = minOf(minCost, costs[x][y])

                if (i + 1 < points.size && grid[x][y] == grid[points[i + 1].first][points[i + 1].second])
                    continue

                for (r in start..i) {
                    val (rx, ry) = points[r]
                    costs[rx][ry] = minCost
                }
                start = i + 1
            }

            for (i in m - 1 downTo 0) {
                for (j in n - 1 downTo 0) {
                    if (i == m - 1 && j == n - 1) {
                        costs[i][j] = 0
                        continue
                    }
                    if (i + 1 < m)
                        costs[i][j] = minOf(costs[i][j], costs[i + 1][j] + grid[i + 1][j])
                    if (j + 1 < n)
                        costs[i][j] = minOf(costs[i][j], costs[i][j + 1] + grid[i][j + 1])
                }
            }
        }
        return costs[0][0]
    }
}
