package april

class Solution3655 {
    private val MOD = 1_000_000_007

    private fun pow(x0: Long, y0: Long): Int {
        var x = x0 % MOD
        var y = y0
        var res = 1L
        while (y > 0) {
            if (y and 1L == 1L) res = res * x % MOD
            x = x * x % MOD
            y = y shr 1
        }
        return res.toInt()
    }

    fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        val n = nums.size
        val T = kotlin.math.sqrt(n.toDouble()).toInt()
        val groups = Array(T) { mutableListOf<IntArray>() }

        for ((l, r, k, v) in queries) {
            if (k < T) groups[k].add(intArrayOf(l, r, v))
            else {
                var i = l
                while (i <= r) {
                    nums[i] = (nums[i].toLong() * v % MOD).toInt()
                    i += k
                }
            }
        }

        val dif = LongArray(n + T)
        for (k in 1 until T) {
            if (groups[k].isEmpty()) continue
            java.util.Arrays.fill(dif, 1)

            for ((l, r, v) in groups[k]) {
                dif[l] = dif[l] * v % MOD
                val R = ((r - l) / k + 1) * k + l
                dif[R] = dif[R] * pow(v.toLong(), MOD - 2L) % MOD
            }

            for (i in k until n) dif[i] = dif[i] * dif[i - k] % MOD
            for (i in nums.indices)
                nums[i] = (nums[i].toLong() * dif[i] % MOD).toInt()
        }

        return nums.reduce { acc, x -> acc xor x }
    }
}