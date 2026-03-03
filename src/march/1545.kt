package march

import kotlin.math.abs
import kotlin.math.pow

class Solution1545 {

    /// Right now I guess pure math can work. This is not pure intuition because I already submitted correct answer.
    /// From several experiments I observed that first char is always 0, last one is always 1.
    /// And the bits inside all of them mathematically possible to find. I write this before solution, so basically I don't
    /// know how possible is this.

    fun findKthBit(n: Int, k: Int): Char {
        /// Let's say we have the string n without calculation.
        /// Totally 2 ^ n - 1 elements are possible. So, 2 ^ n - 2'th element is 1. This is inversion of 0th
        /// So (2 ^ n - 2 - x)th element would be xth element's inversion.
        /// Same is valid for (2 ^ (n - m) - 2), this is always 1, except n - m == 1 case. (Note m != n)
        /// 2 ^ (n - m) - 2 - x th elements always equal to x's inversion
        /// If we have some number k - 1, we should convert it to this format 2 ^ (n - m) - 2 - x then we get x.
        /// Then reproduce it while n - m != 1

        var m = 0
        var x = k
        var counter: Int = 0

        // k = 3
        // n = 2

        while (m != n) {
            if (n - m == 1) return if (counter % 2 == 1) '1' else '0'
            if (x == 2.0.pow(n - m - 1).toInt()) break
            if (x > 2.0.pow(n - m - 1).toInt()) {
                x = 2.0.pow(n - m).toInt() - x
                counter++
            }
            m++
        }
        return if (counter % 2 == 1) '0'
        else '1'
    }
}

fun main() {
    val solution: Solution1545 = Solution1545()

    println(solution.findKthBit(3, 2))
//    println(solution.findKthBit(3, 1))
//    println(solution.findKthBit(4, 11))
//    println(solution.findKthBit(20, 1048575))

}