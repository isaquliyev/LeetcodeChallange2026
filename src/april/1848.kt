package april

class Solution1848 {
    fun getMinDistance(nums: IntArray, target: Int, start: Int) = nums.withIndex().filter { it.value == target }.minOf { kotlin.math.abs(it.index - start) }
}