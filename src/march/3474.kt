package march

class Solution3474 {
    fun generateString(str1: String, str2: String): String {
        val n = str1.length
        val m = str2.length

        val s = CharArray(n + m - 1) { 'a' }
        val fixed = BooleanArray(n + m - 1)

        for (i in 0 until n) {
            if (str1[i] == 'T') {
                for (j in 0 until m) {
                    val pos = i + j
                    if (fixed[pos] && s[pos] != str2[j]) {
                        return ""
                    }
                    s[pos] = str2[j]
                    fixed[pos] = true
                }
            }
        }

        for (i in 0 until n) {
            if (str1[i] == 'F') {
                var differs = false
                var changeIdx = -1

                for (j in m - 1 downTo 0) {
                    val pos = i + j

                    if (s[pos] != str2[j]) {
                        differs = true
                    }
                    if (changeIdx == -1 && !fixed[pos]) {
                        changeIdx = pos
                    }
                }

                if (differs) continue

                if (changeIdx != -1) {
                    s[changeIdx] = 'b'
                } else {
                    return ""
                }
            }
        }

        return String(s)
    }
}