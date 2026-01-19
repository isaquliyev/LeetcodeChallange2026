import kotlin.math.max
import kotlin.math.min

class Solution1292 {
    fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {

        val n: Int = mat.size
        val m: Int = mat[0].size

        var maxSide = min(n, m) + 1

        var minSide = 0
        var mid = (maxSide + minSide) / 2
        var candidate = 0
        var broken = false
        val prefixArr = createPrefixSumArray(arr = mat, n = n, m = m)

        while(mid != minSide && mid != maxSide) {
            outer@ for (i in 0 .. n - mid) {
                for (j in 0 .. m - mid) {
                    val sum = prefixArr[mid + i][mid + j] - prefixArr[i][mid + j] - prefixArr[mid + i][j] + prefixArr[i][j]
                    if (threshold >= sum) {
                        candidate = max(mid, candidate)
                        minSide = mid
                        mid = (mid + maxSide) / 2
                        broken = true
                        break@outer
                    }
                }
            }

            if (!broken) {
                maxSide = mid
                mid = (mid + minSide) / 2
            }
            broken = false
        }
        return candidate
    }

    fun createPrefixSumArray(arr: Array<IntArray>, n: Int, m: Int): Array<IntArray> {

        val prefixSumArray: Array<IntArray> = Array(n + 1) { IntArray(m + 1) }

        for (i in 1 .. n)
            for (j in 1 .. m)
                prefixSumArray[i][j] = prefixSumArray[i - 1][j] + prefixSumArray[i][j - 1] - prefixSumArray[i - 1][j - 1] + arr[i - 1][j - 1]
        return prefixSumArray
    }
}