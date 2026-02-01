package february

class Solution3010 {
    fun minimumCost(nums: IntArray): Int {

        var firstMin = 1
        var secondMin = 2

        for (i in 1 until nums.size) {
            if (nums[i] < nums[firstMin]) {
                secondMin = firstMin
                firstMin = i
            }
            else if (nums[i] < nums[secondMin] && i != firstMin && i != secondMin) {
                secondMin = i
            }
        }

        return nums[0] + nums[firstMin] + nums[secondMin]

    }
}