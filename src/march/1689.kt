package march

import kotlin.math.max

class Solution1689 {
    fun minPartitions(n: String): Int {
        var ans = 0
        for (chr in n) {
            ans = max(chr.digitToInt(), ans)
            if (ans == 9) break
        }
        return ans
    }
}

fun main() {
    println('9'.digitToInt())
}