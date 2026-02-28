package february

import java.lang.Math.pow
import kotlin.math.pow

class Solution1680 {
    fun concatenatedBinary(n: Int): Int {
        // concat a number with next number basicly means multiply it by two.
        // So, we need a counter that will check how large the number. The metric is ln2 here. 1, 2, 4, 8 has different length
        val mod = 1_000_000_007
        var shiftCount: Int = 1
        var counter = 1
        var ans: Long = 0
        for (i in 1 .. n) {
            ans = (ans shl shiftCount) % mod
            counter--
            if (counter == 0) {
                shiftCount++
                counter = 1 shl (shiftCount - 1)
            }
            ans = (ans + i) % mod
        }

        return ans.toInt()
    }
}

fun main() {

    val solution = Solution1680()

    println(solution.concatenatedBinary(12))

}