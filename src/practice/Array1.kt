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

}