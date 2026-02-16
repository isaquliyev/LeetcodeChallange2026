package february

class Solution190 {
    fun reverseBits(n: Int): Int {

        var ans = 0

        var num = n

        repeat(32) {
            ans = ans shl 1

            if (num % 2 != 0) {
                ans += 1
                num -= 1
            }

            num /= 2

        }

        return ans
    }
}
