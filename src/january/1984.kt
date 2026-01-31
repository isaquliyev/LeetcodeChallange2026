import kotlin.math.min

class Solution1984 {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        nums.sort()

        var window: Int = nums[k - 1] - nums[0]

        for (i in k until nums.size) {
            window = min(window,  nums[i] - nums[i - k + 1])
        }

        return window
    }
}