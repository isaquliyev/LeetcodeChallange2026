package february

class Solution3713 {
    fun longestBalanced(s: String): Int {
        val n = s.length
        var res = 0
        val bytes = s.toByteArray()

        for (i in 0 until n) {
            val cnt = IntArray(26)
            for (j in i until n) {
                val c = (bytes[j] - 'a'.code.toByte()).toInt()
                cnt[c]++

                var flag = true
                for (k in 0 until 26) {
                    if (cnt[k] > 0 && cnt[k] != cnt[c]) {
                        flag = false
                        break
                    }
                }

                if (flag) {
                    res = maxOf(res, j - i + 1)
                }
            }
        }

        return res
    }
}