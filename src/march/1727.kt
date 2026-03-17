package march

class Solution1727 {

    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        var ans = 0

        for (row in 0 until m) {
            for (col in 0 until n)
                if (matrix[row][col] != 0 && row > 0)
                    matrix[row][col] += matrix[row - 1][col]

            val curr = matrix[row].sorted()

            for (i in 0 until n)
                ans = maxOf(ans, curr[i] * (n - i))
        }

        return ans
    }
}