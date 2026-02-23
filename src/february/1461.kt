package february

import java.lang.Math.pow
import kotlin.math.pow

class Solution1461 {
    fun hasAllCodes(s: String, k: Int): Boolean {

        val ht = HashSet<Int>()
        var num = 0
        val mask = (1 shl k) - 1

        for (i in 0 until s.length) {
            num = (num shl 1) or (if (s[i] == '1') 1 else 0) and mask
            if (i > k - 1)ht.add(num)
        }

        return ht.size == mask + 1
    }
}

fun main() {
    val solution: Solution1461 = Solution1461()

    println(solution.hasAllCodes("0110", 2))

}