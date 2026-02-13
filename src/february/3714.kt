package february

class Solution3714 {

    fun longestBalanced(s: String): Int {
        val x = calc1(s)
        val y = maxOf(
            calc2(s, 'a', 'b'),
            calc2(s, 'b', 'c'),
            calc2(s, 'a', 'c')
        )
        val z = calc3(s)
        return maxOf(x, y, z)
    }

    fun calc1(s: String): Int {
        var res = 0
        var i = 0

        while (i < s.length) {
            var j = i + 1
            while (j < s.length && s[j] == s[i]) {
                j++
            }
            res = maxOf(res, j - i)
            i = j
        }
        return res
    }

    fun calc2(s: String, a: Char, b: Char): Int {
        var res = 0
        var i = 0

        while (i < s.length) {

            while (i < s.length && s[i] != a && s[i] != b) {
                i++
            }

            val pos = mutableMapOf<Int, Int>()
            pos[0] = i - 1
            var d = 0

            while (i < s.length && (s[i] == a || s[i] == b)) {

                d += when (s[i]) {
                    a -> 1
                    else -> -1
                }

                val prev = pos[d]
                if (prev != null) {
                    res = maxOf(res, i - prev)
                } else {
                    pos[d] = i
                }

                i++
            }
        }

        return res
    }

    fun calc3(s: String): Int {
        val pos = mutableMapOf<Long, Int>()
        pos[f(0, 0)] = -1

        val cnt = IntArray(3)
        var res = 0

        for ((i, c) in s.withIndex()) {
            cnt[c - 'a']++

            val x = cnt[0] - cnt[1]
            val y = cnt[1] - cnt[2]
            val key = f(x, y)

            val prev = pos[key]
            if (prev != null) {
                res = maxOf(res, i - prev)
            } else {
                pos[key] = i
            }
        }

        return res
    }

    fun f(x: Int, y: Int): Long {
        return ((x + 100_000).toLong() shl 20) or (y + 100_000).toLong()
    }
}
