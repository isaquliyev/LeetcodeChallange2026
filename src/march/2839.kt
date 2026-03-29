package march

class Solution2839 {
    fun canBeEqual(s1: String, s2: String): Boolean {
        fun normalize(s: String): String {
            val even = listOf(s[0], s[2]).sorted()
            val odd = listOf(s[1], s[3]).sorted()
            return "${even[0]}${odd[0]}${even[1]}${odd[1]}"
        }
        return normalize(s1) == normalize(s2)
    }
}