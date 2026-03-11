package march

import kotlin.math.pow

class Solution1009 {
    fun bitwiseComplement(n: Int): Int {

        var count = 0
        var m = n
        var sum = 0
        do {
            if (m % 2 == 0) {
                sum += 2.0.pow(count).toInt()
            }
            count++
            m /= 2
        }
        while(m > 0)
        return sum
    }
}

fun main() {
    val solution: Solution1009 = Solution1009()

    println(solution.bitwiseComplement(10))
}