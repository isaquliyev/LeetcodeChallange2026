class Solution {
    fun numOfWays(n: Int): Int {
        val MOD : Int = 1_000_000_007

        var abc : Long = 6
        var aba : Long = 6

        var nextAbc : Long?
        var nextAba : Long?

        for (i in 1 until n) {
            nextAbc = (2 * abc + 2 * aba) % MOD
            nextAba = (3 * aba + 2 * abc) % MOD

            abc = nextAbc
            aba = nextAba
        }

        return ((abc + aba) % MOD).toInt()

    }
}