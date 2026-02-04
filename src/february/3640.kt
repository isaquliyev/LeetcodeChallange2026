package february

class Solution {
    fun maxSumTrionic(nums: IntArray): Long {
        val n = nums.size
        var ans = Long.MIN_VALUE
        var i = 0

        while (i < n) {
            var j = i + 1
            var res = 0L

            while (j < n && nums[j - 1] < nums[j]) j++
            val p = j - 1
            if (p == i) {
                i++
                continue
            }

            res += nums[p].toLong() + nums[p - 1]
            while (j < n && nums[j - 1] > nums[j]) {
                res += nums[j]
                j++
            }
            val q = j - 1

            if (q == p || q == n - 1 || (j < n && nums[j] <= nums[q])) {
                i = q + 1
                continue
            }

            res += nums[q + 1]

            var maxSum = 0L
            var sum = 0L
            var k = q + 2
            while (k < n && nums[k] > nums[k - 1]) {
                sum += nums[k]
                maxSum = maxOf(maxSum, sum)
                k++
            }
            res += maxSum

            maxSum = 0L
            sum = 0L
            k = p - 2
            while (k >= i) {
                sum += nums[k]
                maxSum = maxOf(maxSum, sum)
                k--
            }
            res += maxSum

            ans = maxOf(ans, res)
            i = q
        }

        return ans
    }
}
