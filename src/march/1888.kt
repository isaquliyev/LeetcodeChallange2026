package march

class Solution1888 {

    /// The solution is based on the sliding window technique.
    /// Just required to concatenate s by itself/
    /// First s.length characters would be form first answer according to 0101... or 1010... patterns
    /// if r - l + 1 == s.length, then we can remove s[l] from answer, s[n + r] would compare same bit with another bit in patterns and final result can be decreased.


    fun minFlips(s: String): Int {
        val n = s.length
        val s2 = s + s
        var diff1 = 0
        var diff2 = 0

        fun alt1(i: Int) = if (i % 2 == 0) '0' else '1'
        fun alt2(i: Int) = if (i % 2 == 0) '1' else '0'

        var l = 0
        var res = Int.MAX_VALUE
        for (r in 0 until 2 * n) {
            if (s2[r] != alt1(r)) diff1++
            if (s2[r] != alt2(r)) diff2++

            if (r - l + 1 > n) {
                if (s2[l] != alt1(l)) diff1--
                if (s2[l] != alt2(l)) diff2--
                l++
            }

            if (r - l + 1 == n) {
                res = minOf(res, diff1, diff2)
            }
        }
        return res
    }
}