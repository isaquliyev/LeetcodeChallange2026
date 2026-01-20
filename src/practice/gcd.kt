package practice

import kotlin.math.max
import kotlin.math.min

fun gcd(a: Int, b: Int): Int {


    val big = max(a, b)
    val small = min(a, b)

    if (big % small == 0) return small

    return gcd(big % small, small)
}

fun main() {
    println(gcd(105, 224))
}