package april

class Solution1559 {
    fun containsCycle(grid: Array<CharArray>): Boolean {
        val m = grid.size
        val n = grid[0].size
        val uf = UnionFind(m * n)

        for (i in 0 until m) {
            for (j in 0 until n) {
                val id = i * n + j

                if (i > 0 && grid[i][j] == grid[i - 1][j]) {
                    if (!uf.union(id, (i - 1) * n + j)) return true
                }

                if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                    if (!uf.union(id, i * n + j - 1)) return true
                }
            }
        }
        return false
    }
}

private class UnionFind(n: Int) {

    private val parent = IntArray(n) { it }
    private val size = IntArray(n) { 1 }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x]) // path compression
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        var rootX = find(x)
        var rootY = find(y)

        if (rootX == rootY) return false

        if (size[rootX] < size[rootY]) {
            rootX = rootY.also { rootY = rootX }
        }

        parent[rootY] = rootX
        size[rootX] += size[rootY]
        return true
    }
}