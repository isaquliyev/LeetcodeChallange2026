package march

class Solution1980 {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val n = nums.size
        generate(n).forEach { if (it !in nums) return it }
        throw Exception()
    }

    fun generate(n: Int): Sequence<String> =
        (0..n).asSequence().map { it.toString(2).padStart(n, '0') }
}