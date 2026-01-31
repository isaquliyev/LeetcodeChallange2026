import kotlin.math.min

class Solution3507 {
    fun minimumPairRemoval(nums: IntArray): Int {

        val list = nums.toMutableList()
        var count = 0

        while (list.size > 1) {

            if (list.indices.drop(1).all { i -> list[i - 1] <= list[i] }) break

            var m = Int.MAX_VALUE
            var idx = 0

            for (i in 1 until list.size) {
                if (list[i] + list[i - 1] < m) {
                    m = list[i] + list[i - 1]
                    idx = i - 1
                }
            }

            count++

            list[idx] = list[idx] + list[idx + 1]
            list.removeAt(idx + 1)
        }

        return count
    }
}