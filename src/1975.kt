import kotlin.math.abs

class Solution1975 {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var minMatrix : Int = matrix[0][0]
        var sum : Long = 0
        var negativeCounter : Int = 0
        for (row in matrix) {
            for (col in row) {
                if (abs(col) < abs(minMatrix)) minMatrix = col
                sum += abs(col)
                if (col < 0) negativeCounter++
            }
        }
        return when {
            negativeCounter % 2 == 0 -> sum;
            else -> sum - 2 * abs(minMatrix)
        }
    }
}