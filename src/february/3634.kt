package february

import kotlin.math.min

class Solution3634 {
    fun minRemoval(nums: IntArray, k: Int): Int {
        var ans = Int.MAX_VALUE
        val n = nums.size
        var j = 0
        nums.sort()
        for (i in 0 until n) {
            while (j < n && nums[j].toLong() <= k.toLong() * nums[i].toLong()) {
                j++
            }
            ans = min(ans, n - j + i)
        }
        return ans
    }
}