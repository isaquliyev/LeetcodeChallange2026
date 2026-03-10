package march

class Solution3130 {
    companion object {
        private const val MOD = 1_000_000_007
    }

    private lateinit var memo: Array<Array<IntArray>>
    private var limit = 0

    fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
        this.limit = limit
        memo = Array(zero + 1) { Array(one + 1) { IntArray(2) { -1 } } }
        return (dp(zero, one, 0) + dp(zero, one, 1)) % MOD
    }

    private fun dp(zero: Int, one: Int, lastBit: Int): Int {
        if (zero == 0) return if (lastBit == 0 || one > limit) 0 else 1
        if (one == 0) return if (lastBit == 1 || zero > limit) 0 else 1

        if (memo[zero][one][lastBit] != -1) return memo[zero][one][lastBit]

        val res = if (lastBit == 0) {
            var r = (dp(zero - 1, one, 0) + dp(zero - 1, one, 1)) % MOD
            if (zero > limit) r = (r - dp(zero - limit - 1, one, 1) + MOD) % MOD
            r
        } else {
            var r = (dp(zero, one - 1, 0) + dp(zero, one - 1, 1)) % MOD
            if (one > limit) r = (r - dp(zero, one - limit - 1, 0) + MOD) % MOD
            r
        }

        return res.also { memo[zero][one][lastBit] = it }
    }
}