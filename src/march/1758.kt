package march

import kotlin.math.min

class Solution1758 {

    /// We have basically 2 patterns.
    /// 10101010101010101 or 010101010101010101010
    /// So, if we count differences with these patterns and compare, it is likely to be the answer.

    fun minOperations(s: String): Int {
        var counter1: Int = 0
        var counter2: Int = 0

        for (i in 0 until s.length) {
            if ((i % 2 == 0 && s[i] == '1') || (i % 2 == 1 && s[i] == '0')) counter1++

            if ((i % 2 == 1 && s[i] == '1') || (i % 2 == 0 && s[i] == '0')) counter2++
        }

        return min(counter1, counter2)
    }
}