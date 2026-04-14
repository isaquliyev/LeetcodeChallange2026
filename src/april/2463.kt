package april

class Solution2463 {
    fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
        val r = robot.sorted()
        val f = factory.sortedBy { it[0] }
        val fp = ArrayList<Int>()
        for ((pos, cap) in f) repeat(cap) { fp.add(pos) }

        val dp = Array(r.size) { LongArray(fp.size) { -1 } }

        fun dfs(i: Int, j: Int): Long {
            if (i == r.size) return 0
            if (j == fp.size) return 1_000_000_000_000L
            if (dp[i][j] != -1L) return dp[i][j]

            val assign = kotlin.math.abs(r[i] - fp[j]) + dfs(i + 1, j + 1)
            val skip = dfs(i, j + 1)
            return minOf(assign, skip).also { dp[i][j] = it }
        }

        return dfs(0, 0)
    }
}