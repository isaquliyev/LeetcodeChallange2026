package march

import kotlin.math.abs
import kotlin.math.min

class Solution3567 {
    fun minAbsDiff(grid: Array<IntArray>, k: Int): Array<IntArray> {

        val n = grid.size
        val m = grid[0].size
        val ans = Array(n - k + 1) { IntArray (m - k + 1) }
        val l = mutableListOf<Int>()


        for (i in 0 .. (n - k)) {
            for (j in 0 .. (m - k)) {

                for (x in i until i + k) {
                    for (y in j until j + k) {
                        l.add(grid[x][y])
                    }
                }
                l.sort()

                ans[i][j] = minimumDiff(l)
                l.clear()
            }
        }

        return ans
    }

    fun minimumDiff(l: MutableList<Int>) : Int {
        var minValue: Int = Int.MAX_VALUE

        println(l.joinToString())

        for (i in 0 until l.size - 1) {
            if (l[i] == l[i + 1]) continue
            minValue = minOf(minValue, l[i + 1] - l[i])
        }

        return if (minValue == Int.MAX_VALUE) 0 else minValue
    }
}