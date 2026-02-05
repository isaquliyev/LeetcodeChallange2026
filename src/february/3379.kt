package february

class Solution {
    fun constructTransformedArray(nums: IntArray): IntArray {

        val n = nums.size

        val result: IntArray = IntArray(n)

        for (i in 0 until n)
            result[i] = nums[Math.floorMod(i + nums[i], n)]

        return result
    }
}