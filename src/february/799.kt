package february

class Solution799 {

    fun champagneTower(poured: Int, queryRow: Int, queryGlass: Int): Double {
        val tower = Array(102) { DoubleArray(102) }
        tower[0][0] = poured.toDouble()

        for (row in 0..queryRow) {
            for (col in 0..row) {
                val overflow = (tower[row][col] - 1.0) / 2.0
                if (overflow > 0) {
                    tower[row + 1][col] += overflow
                    tower[row + 1][col + 1] += overflow
                }
            }
        }

        return minOf(1.0, tower[queryRow][queryGlass])
    }
}