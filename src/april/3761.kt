package april

class Solution3761 {
    fun minMirrorPairDistance(nums: IntArray): Int {
        val prev = HashMap<Int, Int>()
        var ans = nums.size + 1
        for (i in nums.indices) {
            val x = nums[i]
            prev[x]?.let { ans = minOf(ans, i - it) }
            prev[reverse(x)] = i
        }
        return if (ans == nums.size + 1) -1 else ans
    }

    fun reverse(x: Int): Int {
        var n = x
        var r = 0
        while (n > 0) {
            r = r * 10 + n % 10
            n /= 10
        }
        return r
    }
}