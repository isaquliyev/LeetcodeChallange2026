package april

class Solution3741 {
    fun minimumDistance(nums: IntArray): Int {
        val next = IntArray(nums.size) { -1 }
        val last = HashMap<Int, Int>()
        var ans = nums.size + 1

        for (i in nums.lastIndex downTo 0)
            next[i] = last.put(nums[i], i) ?: -1

        for (i in nums.indices)
            next[i].takeIf { it != -1 }?.let { j ->
                next[j].takeIf { it != -1 }?.let { k ->
                    ans = minOf(ans, k - i)
                }
            }

        return if (ans > nums.size) -1 else ans * 2
    }
}