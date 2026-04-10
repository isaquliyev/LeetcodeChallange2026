package april

class Solution3740 {
    fun minimumDistance(nums: IntArray): Int {
        val n = nums.size
        var ans = n + 1
        for (i in 0 until n - 2)
            for (j in i + 1 until n - 1)
                if (nums[i] == nums[j])
                    for (k in j + 1 until n)
                        if (nums[j] == nums[k]) {
                            ans = minOf(ans, k - i)
                            break
                        }
        return if (ans == n + 1) -1 else ans * 2
    }
}