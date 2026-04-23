package april

class Solution2615 {
    fun distance(a: IntArray) = LongArray(a.size).also { r ->
        a.indices.groupBy { a[it] }.values.forEach { g ->
            var t = g.sumOf { it.toLong() }
            var p = 0L
            val s = g.size
            g.forEachIndexed { i, x ->
                r[x] = t - 2 * p + x.toLong() * (2 * i - s)
                p += x
            }
        }
    }
}