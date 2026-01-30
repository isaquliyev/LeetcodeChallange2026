class Trie {
    val child = arrayOfNulls<Trie>(26)
    var id = -1
}

class Solution2977 {
    private val INF = Int.MAX_VALUE / 2

    private fun add(node0: Trie, word: String, idx: IntArray): Int {
        var node = node0
        for (c in word) {
            val i = c - 'a'
            node = node.child[i] ?: Trie().also { node.child[i] = it }
        }
        if (node.id == -1) node.id = ++idx[0]
        return node.id
    }

    fun minimumCost(source: String, target: String, original: Array<String>, changed: Array<String>, cost: IntArray): Long {
        val n = source.length
        val m = original.size
        val root = Trie()
        val p = intArrayOf(-1)

        val G = Array(m * 2) { IntArray(m * 2) { INF } }
        for (i in G.indices) G[i][i] = 0

        for (i in 0 until m) {
            val x = add(root, original[i], p)
            val y = add(root, changed[i], p)
            G[x][y] = minOf(G[x][y], cost[i])
        }

        val size = p[0] + 1
        for (k in 0 until size)
            for (i in 0 until size)
                for (j in 0 until size)
                    G[i][j] = minOf(G[i][j], G[i][k] + G[k][j])

        val f = LongArray(n) { -1 }
        for (j in 0 until n) {
            if (j > 0 && f[j - 1] == -1L) continue
            val base = if (j == 0) 0L else f[j - 1]

            if (source[j] == target[j])
                f[j] = if (f[j] == -1L) base else minOf(f[j], base)

            var u: Trie? = root
            var v: Trie? = root
            for (i in j until n) {
                u = u?.child[source[i] - 'a']
                v = v?.child[target[i] - 'a']
                if (u == null || v == null) break
                if (u.id != -1 && v.id != -1 && G[u.id][v.id] != INF) {
                    val nv = base + G[u.id][v.id]
                    if (f[i] == -1L || nv < f[i]) f[i] = nv
                }
            }
        }
        return f[n - 1]
    }
}
