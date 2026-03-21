package march

class Solution3643 {
    fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray> {
        var i0 = x
        var i1 = x + k - 1

        while (i0 < i1) {
            for (j in y until y + k) {
                grid[i0][j] = grid[i1][j].also {
                    grid[i1][j] = grid[i0][j]
                }
            }
            i0++
            i1--
        }

        return grid
    }
}