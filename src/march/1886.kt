package march

class Solution1886 {
    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val n = mat.size

        repeat(4) {
            for (i in 0 until n / 2) {
                for (j in 0 until (n + 1) / 2) {
                    val temp = mat[i][j]
                    mat[i][j] = mat[n - 1 - j][i]
                    mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j]
                    mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i]
                    mat[j][n - 1 - i] = temp
                }
            }
            if (mat.contentDeepEquals(target)) return true
        }
        return false
    }
}