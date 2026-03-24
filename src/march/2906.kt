package march

class Solution2906 {
    fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
        val MOD = 12345
        val n = grid.size
        val m = grid[0].size
        val res = Array(n) { IntArray(m) }

        var suffix = 1L
        for (i in n - 1 downTo 0) {
            for (j in m - 1 downTo 0) {
                res[i][j] = suffix.toInt()
                suffix = (suffix * grid[i][j]) % MOD
            }
        }

        var prefix = 1L
        for (i in 0 until n) {
            for (j in 0 until m) {
                res[i][j] = ((res[i][j] * prefix) % MOD).toInt()
                prefix = (prefix * grid[i][j]) % MOD
            }
        }

        return res
    }
}