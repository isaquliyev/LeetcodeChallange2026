package april

class Solution3653 {
    fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        val MOD = 1_000_000_007
        queries.forEach { (l, r, k, v) ->
            for (i in l..r step k)
                nums[i] = ((nums[i].toLong() * v) % MOD).toInt()
        }
        return nums.reduce { acc, x -> acc xor x }
    }
}