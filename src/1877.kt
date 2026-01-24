import kotlin.math.max

class Solution1877 {
    fun minPairSum(nums: IntArray): Int {

        nums.sort()

        var m: Int = 0

        for (i in 0 until nums.size) {
            m = max(m, nums[i] + nums[nums.size - 1 - i])
        }

        return m
    }
}