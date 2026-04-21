package april

class Solution1722 {
    lateinit var fa: IntArray
    lateinit var rank: IntArray

    fun find(x: Int): Int =
        if (fa[x] == x) x else find(fa[x]).also { fa[x] = it }

    fun union(x: Int, y: Int) {
        var a = find(x)
        var b = find(y)
        if (a == b) return
        if (rank[a] < rank[b]) a = b.also { b = a }
        fa[b] = a
        if (rank[a] == rank[b]) rank[a]++
    }

    fun minimumHammingDistance(
        source: IntArray,
        target: IntArray,
        allowedSwaps: Array<IntArray>
    ): Int {
        val n = source.size
        fa = IntArray(n) { it }
        rank = IntArray(n)

        allowedSwaps.forEach { union(it[0], it[1]) }

        val sets = HashMap<Int, MutableMap<Int, Int>>()
        for (i in 0 until n) {
            val f = find(i)
            val cnt = sets.getOrPut(f) { HashMap() }
            cnt[source[i]] = (cnt[source[i]] ?: 0) + 1
        }

        return (0 until n).count { i ->
            val cnt = sets[find(i)]!!
            val t = target[i]
            if ((cnt[t] ?: 0) > 0) {
                cnt[t] = cnt[t]!! - 1
                false
            } else true
        }
    }
}