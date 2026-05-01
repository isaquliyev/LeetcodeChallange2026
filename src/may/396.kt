package may

class Solution396 {
    fun maxRotateFunction(nums: IntArray): Int {
        val n = nums.size
        var f = 0
        val numSum = nums.sum()

        for (i in 0 until n) {
            f += i * nums[i]
        }

        var res = f

        for (i in n - 1 downTo 1) {
            f += numSum - n * nums[i]
            res = maxOf(res, f)
        }

        return res
    }
}