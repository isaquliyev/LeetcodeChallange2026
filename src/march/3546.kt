package march

class Solution {
    fun canPartitionGrid(grid: Array<IntArray>): Boolean {
        val r = grid.size
        val c = grid[0].size
        val row = LongArray(r)
        val col = LongArray(c)
        for (i in 0 until r) {
            if (i > 0) row[i] += row[i - 1]
            for (j in 0 until c) {
                val x = grid[i][j].toLong()
                row[i] += x
                col[j] += x
            }
        }
        for (j in 1 until c) col[j] += col[j - 1]
        val total = col[c - 1]
        if (total and 1L == 1L) return false
        val target = total / 2
        var l = 0; var h = r
        while (l < h) {
            val m = (l + h) ushr 1
            if (row[m] < target) l = m + 1 else h = m
        }
        if (l < r && row[l] == target) return true
        l = 0; h = c
        while (l < h) {
            val m = (l + h) ushr 1
            if (col[m] < target) l = m + 1 else h = m
        }
        return l < c && col[l] == target
    }
}