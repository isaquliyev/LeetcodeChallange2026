class Solution1458 {
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {

        val n = nums1.size
        val m = nums2.size

        val dp: Array<IntArray> = Array(n+1) {
            IntArray(m+1) { - 1_000_000 }
        }

        for (i in 1 .. n) {
            for (j in 1 .. m) {
                val tempProd: Int = nums1[i - 1] * nums2[j - 1]

                val candidates = listOf<Int>(
                    tempProd,
                    tempProd + dp[i - 1][j - 1],
                    dp[i - 1][j],
                    dp[i][j - 1]
                )


                dp[i][j] = candidates.max()
            }
        }

        return dp[n][m]
    }
}