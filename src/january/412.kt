import kotlin.math.min

class Solution412 {
    fun minimumDeleteSum(s1: String, s2: String): Int {

        val l1: Int = s1.length
        val l2: Int = s2.length

        val dp: Array<IntArray> = Array(l1 + 1) { IntArray(l2 + 1) }

        for (i in 1 .. l1) dp[i][0] = dp[i - 1][0] + s1[i - 1].code

        for (j in 1 .. l2) dp[0][j] = dp[0][j - 1] + s2[j - 1].code

        for (i in 1 .. l1) {
            for (j in 1 .. l2) {
                dp[i][j] = if (s1[i - 1] == s2[j - 1]) dp[i - 1][j - 1]
                else min(
                    dp[i - 1][j] + s1[i - 1].code,
                    dp[i][j - 1] + s2[j - 1].code,
                )
            }

        }
        return dp[l1][l2]
    }
}