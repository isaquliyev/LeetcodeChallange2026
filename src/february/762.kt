package february

class Solution762 {
    fun countPrimeSetBits(left: Int, right: Int): Int {

        val primes = listOf<Int>(2, 3, 5, 7, 11, 13, 17, 19)

        var count = 0

        for (i in left .. right) {

            if (Integer.bitCount(i) in primes) count++

        }

        return count
    }
}