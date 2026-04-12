package april

class Solution1320 {
    fun dist(a: Int, b: Int): Int {
        val x1 = a / 6
        val y1 = a % 6
        val x2 = b / 6
        val y2 = b % 6
        return kotlin.math.abs(x1 - x2) + kotlin.math.abs(y1 - y2)
    }

    fun minimumDistance(word: String): Int {
        var dp = Array(26) { IntArray(26) { Int.MAX_VALUE / 2 } }

        val first = word[0] - 'A'
        for (i in 0 until 26) {
            dp[i][first] = 0
            dp[first][i] = 0
        }

        for (i in 1 until word.length) {
            val cur = word[i] - 'A'
            val next = Array(26) { IntArray(26) { Int.MAX_VALUE / 2 } }

            for (l in 0 until 26) {
                for (r in 0 until 26) {
                    val cost = dp[l][r]
                    next[cur][r] = minOf(next[cur][r], cost + dist(l, cur))
                    next[l][cur] = minOf(next[l][cur], cost + dist(r, cur))
                }
            }

            dp = next
        }

        return dp.minOf { it.min() }
    }
}