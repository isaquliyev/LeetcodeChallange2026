package march

class Solution3070 {
    fun countSubmatrices(grid: Array<IntArray>, k: Int): Int {
        val n = grid.size
        val m = grid[0].size
        val cols = IntArray(m)
        var res = 0

        for (i in 0 until n) {
            var rows = 0
            for (j in 0 until m) {
                cols[j] += grid[i][j]
                rows += cols[j]
                if (rows <= k) {
                    res++
                }
            }
        }

        return res
    }
}