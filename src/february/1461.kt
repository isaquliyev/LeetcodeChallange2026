package february

import java.lang.Math.pow
import kotlin.math.pow

class Solution1461 {
    fun hasAllCodes(s: String, k: Int): Boolean {

        val ht = HashSet<String>()

        for (i in 0 until s.length - k)
            ht.add(s.substring(i, i + k))

        return ht.size == 2.0.pow(k).toInt()
    }
}

fun main() {
    val solution: Solution1461 = Solution1461()

    println(solution.hasAllCodes("0110", 1))

}