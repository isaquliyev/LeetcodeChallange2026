class Solution {

    fun repeatedNTimes(nums: IntArray): Int {

        when {
            nums[0] == nums[1] || nums[0] == nums[2]-> return nums[0]
            nums[1] == nums[2] -> return nums[1]
        }

        var vote : Int = 0
        var candidate : Int = -1
        for (i in 3 until nums.size) {
            if (candidate == nums[i]) vote++
            else vote--
            if (vote <= 0) {
                candidate = nums[i]
                vote = 1
            }
        }

        return candidate
    }
}