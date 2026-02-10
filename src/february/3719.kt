package february

class Solution3719 {

    fun longestBalanced(nums: IntArray): Int {
        var len = 0

        for (i in nums.indices) {
            val odd = mutableMapOf<Int, Int>()
            val even = mutableMapOf<Int, Int>()

            for (j in i until nums.size) {
                val map = if (nums[j] and 1 == 1) odd else even
                map[nums[j]] = map.getOrDefault(nums[j], 0) + 1

                if (odd.size == even.size) {
                    len = maxOf(len, j - i + 1)
                }
            }
        }

        return len
    }
}
