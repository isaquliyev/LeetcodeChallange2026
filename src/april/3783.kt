package april

class Solution3783 {
    fun reverse(n: Int): Int {
        var x = n
        var r = 0
        while (x > 0) {
            r = r * 10 + x % 10
            x /= 10
        }
        return r
    }

    fun mirrorDistance(n: Int) = kotlin.math.abs(n - reverse(n))
}