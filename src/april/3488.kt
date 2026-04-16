package april

class Solution3488 {
    fun solveQueries(nums: IntArray, queries: IntArray): List<Int> {
        val n = nums.size
        val map = mutableMapOf<Int, MutableList<Int>>()

        nums.forEachIndexed { i, v -> map.getOrPut(v) { mutableListOf() }.add(i) }

        map.values.forEach { pos ->
            val first = pos.first()
            val last = pos.last()
            pos.add(0, last - n)
            pos.add(first + n)
        }

        return queries.map { q ->
            val pos = map[nums[q]]!!
            if (pos.size == 3) return@map -1

            var idx = pos.binarySearch(q)
            if (idx < 0) idx = -idx - 1

            minOf(pos[idx + 1] - pos[idx], pos[idx] - pos[idx - 1])
        }
    }
}