package march

class Solution3648 {
    fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        var g = grid
        val total = g.sumOf { row -> row.sumOf { it.toLong() } }

        repeat(4) {
            val m = g.size
            val n = g[0].size

            if (m < 2) {
                g = rotate(g)
                return@repeat
            }

            var sum = 0L
            val seen = HashSet<Long>().apply { add(0L) }

            if (n == 1) {
                for (i in 0 until m - 1) {
                    sum += g[i][0]
                    val tag = sum * 2 - total
                    if (tag == 0L || tag == g[0][0].toLong() || tag == g[i][0].toLong()) return true
                }
                g = rotate(g)
                return@repeat
            }

            for (i in 0 until m - 1) {
                for (j in 0 until n) {
                    seen.add(g[i][j].toLong())
                    sum += g[i][j]
                }
                val tag = sum * 2 - total
                if (i == 0) {
                    if (tag == 0L || tag == g[0][0].toLong() || tag == g[0][n - 1].toLong()) return true
                } else if (seen.contains(tag)) {
                    return true
                }
            }

            g = rotate(g)
        }

        return false
    }

    private fun rotate(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size
        return Array(n) { j -> IntArray(m) { i -> grid[m - 1 - i][j] } }
    }
}