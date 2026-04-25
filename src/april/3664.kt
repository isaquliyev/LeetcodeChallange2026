package april

class Solution3664 {

    fun maxDistance(side: Int, points: Array<IntArray>, k: Int): Int {
        val arr = points.map { (x, y) ->
            when {
                x == 0 -> y.toLong()
                y == side -> side + x.toLong()
                x == side -> 3L * side - y
                else -> 4L * side - x
            }
        }.sorted()

        var lo = 1L
        var hi = side.toLong()
        var ans = 0L

        while (lo <= hi) {
            val mid = (lo + hi) / 2
            if (check(arr, side, k, mid)) {
                ans = mid
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }
        return ans.toInt()
    }

    private fun check(arr: List<Long>, side: Int, k: Int, limit: Long): Boolean {
        val perimeter = 4L * side

        for (start in arr) {
            var cur = start
            val end = start + perimeter - limit
            var ok = true

            repeat(k - 1) {
                val idx = arr.binarySearch(cur + limit)
                    .let { if (it < 0) -it - 1 else it }

                if (idx == arr.size || arr[idx] > end) {
                    ok = false
                    return@repeat
                }
                cur = arr[idx]
            }

            if (ok) return true
        }
        return false
    }
}