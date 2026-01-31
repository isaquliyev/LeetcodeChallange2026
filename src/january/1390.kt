class Solution1390 {
    fun sumFourDivisors(nums: IntArray): Int {
        var finalSum : Int = 0
        for (i in nums) {
            var count = 0
            var tempSum = 0
            for (j in 2 .. kotlin.math.sqrt(i.toDouble()).toInt()) {
                if (i % j == 0) {
                    count += if (i / j == j) 1 else 2
                    tempSum += j + i / j
                }
            }
            if (count == 2) finalSum += 1 + tempSum + i
        }

        return finalSum
    }
}