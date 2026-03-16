package march

class Answer {

    private val ans = IntArray(3)

    fun put(x: Int) {
        if (x > ans[0]) {
            ans[2] = ans[1]
            ans[1] = ans[0]
            ans[0] = x
        } else if (x != ans[0] && x > ans[1]) {
            ans[2] = ans[1]
            ans[1] = x
        } else if (x != ans[0] && x != ans[1] && x > ans[2])
            ans[2] = x
    }

    fun get(): List<Int> =
        buildList {
            for (v in ans)
                if (v != 0) add(v)
        }
}

class Solution1878 {

    fun getBiggestThree(grid: Array<IntArray>): IntArray {
        val m = grid.size
        val n = grid[0].size

        val sum1 = Array(m + 1) { IntArray(n + 2) }
        val sum2 = Array(m + 1) { IntArray(n + 2) }

        for (i in 1..m)
            for (j in 1..n) {
                sum1[i][j] = sum1[i - 1][j - 1] + grid[i - 1][j - 1]
                sum2[i][j] = sum2[i - 1][j + 1] + grid[i - 1][j - 1]
            }

        val ans = Answer()

        for (i in grid.indices)
            for (j in grid[0].indices) {

                ans.put(grid[i][j])

                var k = i + 2
                while (k < m) {
                    val ux = i
                    val uy = j

                    val dx = k
                    val dy = j

                    val lx = (i + k) / 2
                    val ly = j - (k - i) / 2

                    val rx = (i + k) / 2
                    val ry = j + (k - i) / 2

                    if (ly < 0 || ry >= n) break

                    val sum =
                        (sum2[lx + 1][ly + 1] - sum2[ux][uy + 2]) +
                                (sum1[rx + 1][ry + 1] - sum1[ux][uy]) +
                                (sum1[dx + 1][dy + 1] - sum1[lx][ly]) +
                                (sum2[dx + 1][dy + 1] - sum2[rx][ry + 2]) -
                                (grid[ux][uy] + grid[dx][dy] + grid[lx][ly] + grid[rx][ry])

                    ans.put(sum)
                    k += 2
                }
            }

        val res = ans.get()
        return IntArray(res.size) { res[it] }
    }
}