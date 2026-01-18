import kotlin.math.max
import kotlin.math.min

class Solution1895 {
    fun largestMagicSquare(grid: Array<IntArray>): Int {

        val n: Int = grid.size
        val m: Int = grid[0].size

        val maxPossibleSize = min(m, n)
        var maxSize = 1

        for (i in 0 until n) {
            for (j in 0 until m) {
                for (k in 2..maxPossibleSize) {
                    if (m - j < k || n - i < k)
                        continue
                    if (isMagicSquare(grid= grid, row = i, column = j, size = k)) {
                        maxSize = max(maxSize, k)
                    }
                }
            }
        }

        return maxSize
    }

    fun isMagicSquare(grid: Array<IntArray>, row: Int, column: Int, size: Int): Boolean {

        val answers: LongArray = LongArray(2 * size + 2)


        for (i in 0 until size) {
            for (j in 0 until size) {
                answers[i] += grid[row + i][column + j]
                answers[size + i] += grid[row + j][column + i]
                if (i == j) answers[2 * size] += grid[row + i][column + i]
                if (i == size - j - 1) answers[2 * size + 1] += grid[row + i][column + j]
            }
        }

        // println(answers.joinToString())


        return answers.all { it == answers[0] }
    }
}