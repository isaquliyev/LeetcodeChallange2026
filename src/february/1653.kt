package february

import kotlin.math.min

class Solution1653 {
    fun minimumDeletions(s: String): Int {

        val n = s.length
        var ans = Int.MAX_VALUE
        val preprocessedArray: IntArray = IntArray(n + 1)

        for (i in 1 .. n) {
            if (s[i - 1] == 'a') preprocessedArray[i] = preprocessedArray[i - 1] + 1
            else preprocessedArray[i] = preprocessedArray[i - 1]
        }

        for (i in 0 .. n)
            ans = min(ans, i - 2 * preprocessedArray[i] + preprocessedArray[n])

        return ans
    }
}