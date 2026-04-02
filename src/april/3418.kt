package april

class Solution {
    fun maximumAmount(coins: Array<IntArray>): Int {
        val m = coins.size
        val n = coins[0].size
        val memo = Array(m) { Array(n) { IntArray(3) { Int.MIN_VALUE } } }

        fun dfs(i: Int, j: Int, k: Int): Int {
            if (i >= m || j >= n) return Int.MIN_VALUE
            if (memo[i][j][k] != Int.MIN_VALUE) return memo[i][j][k]

            val x = coins[i][j]
            if (i == m - 1 && j == n - 1)
                return (if (k > 0) maxOf(0, x) else x).also { memo[i][j][k] = it }

            var res = maxOf(dfs(i + 1, j, k), dfs(i, j + 1, k)) + x

            if (k > 0 && x < 0)
                res = maxOf(res, maxOf(dfs(i + 1, j, k - 1), dfs(i, j + 1, k - 1)))

            return res.also { memo[i][j][k] = it }
        }

        return dfs(0, 0, 2)
    }
}