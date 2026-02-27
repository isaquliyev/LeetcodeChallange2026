package february

import java.util.TreeSet
import kotlin.math.max
import kotlin.math.min

class Solution3666 {

    fun minOperations(s: String, k: Int): Int {
        val n = s.length
        var m = 0
        val dist = IntArray(n + 1) { Int.MAX_VALUE }

        val nodeSets = mutableListOf<TreeSet<Int>>().apply {
            repeat(2) { add(TreeSet()) }
        }

        for (i in 0..n) {
            nodeSets[i % 2].add(i)
            if (i < n && s[i] == '0') {
                m++
            }
        }

        val q = ArrayDeque<Int>()
        q.addLast(m)
        dist[m] = 0
        nodeSets[m % 2].remove(m)

        while (q.isNotEmpty()) {
            val curr = q.removeFirst()

            val c1 = max(k - n + curr, 0)
            val c2 = min(curr, k)

            val lnode = curr + k - 2 * c2
            val rnode = curr + k - 2 * c1

            val nodeSet = nodeSets[lnode % 2]

            var next = nodeSet.ceiling(lnode)
            while (next != null && next <= rnode) {
                dist[next] = dist[curr] + 1
                q.addLast(next)
                nodeSet.remove(next)
                next = nodeSet.ceiling(lnode)
            }
        }

        return if (dist[0] == Int.MAX_VALUE) -1 else dist[0]
    }
}