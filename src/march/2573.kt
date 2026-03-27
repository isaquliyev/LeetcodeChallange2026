package march

class Solution2573 {
    fun findTheString(lcp: Array<IntArray>): String {
        val n = lcp.size
        val w = CharArray(n)
        var c = 'a'
        for (i in 0 until n) if (w[i] == '\u0000') {
            if (c > 'z') return ""
            w[i] = c
            for (j in i + 1 until n) if (lcp[i][j] > 0) w[j] = c
            c++
        }
        for (i in n - 1 downTo 0)
            for (j in n - 1 downTo 0)
                if (w[i] != w[j]) {
                    if (lcp[i][j] != 0) return ""
                } else {
                    if (i == n - 1 || j == n - 1) {
                        if (lcp[i][j] != 1) return ""
                    } else if (lcp[i][j] != lcp[i + 1][j + 1] + 1) return ""
                }
        return String(w)
    }
}