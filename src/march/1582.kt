package march

class Solution1582 {
    fun numSpecial(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val rowCount = IntArray(m)
        val colCount = IntArray(n)

        for (row in 0 until m) {
            for (col in 0 until n) {
                if (mat[row][col] == 1) {
                    rowCount[row]++
                    colCount[col]++
                }
            }
        }

        var ans = 0
        for (row in 0 until m) {
            for (col in 0 until n) {
                if (mat[row][col] == 1) {
                    if (rowCount[row] == 1 && colCount[col] == 1) {
                        ans++
                    }
                }
            }
        }

        return ans
    }
}