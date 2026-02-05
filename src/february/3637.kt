package february

class Solution3637 {
    fun isTrionic(nums: IntArray): Boolean {

        var flag = 0

        for (i in 1 until nums.size) {
            flag = if (flag in 0 .. 1 && nums[i] > nums[i - 1])
                1
            else if (flag in 1 .. 2 && nums[i] < nums[i - 1])
                2
            else if (flag in 2 .. 3 && nums[i] > nums[i - 1])
                3
            else return false
        }

        return flag == 3
    }
}