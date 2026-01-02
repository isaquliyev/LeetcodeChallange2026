package practice

class Array1 {

    fun getConcatenation(nums: IntArray): IntArray {
        return intArrayOf(*nums, *nums)
    }

    fun shuffle(nums: IntArray, n: Int): IntArray {
        val arr = IntArray(2 * n)
        for (i in 0 until n) {
            arr[2 * i] = nums[i]
            arr[2 * i + 1] = nums[n + i]
        }

        return arr
    }

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var temp : Int = 0
        var counter : Int = 0
        for (i in nums) {
            if (i == 1) temp++
            else {
                counter = if (counter > temp) counter else temp
                temp = 0
            }
        }

        return if (counter > temp) counter else temp
    }

}