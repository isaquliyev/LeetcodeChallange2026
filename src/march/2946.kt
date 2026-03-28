package march

class Solution2946 {
    fun areSimilar(mat: Array<IntArray>, k: Int): Boolean {
        val n = mat[0].size
        val s = k % n
        for (r in mat) for (j in r.indices)
            if (r[j] != r[(j + s) % n]) return false
        return true
    }
}