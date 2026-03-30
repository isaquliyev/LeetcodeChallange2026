package march

class Solution2840 {
    fun checkStrings(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) return false

        val count1 = IntArray(256)
        val count2 = IntArray(256)

        for (i in s1.indices) {
            val offset = (i and 1) shl 7
            count1[offset + s1[i].code]++
            count2[offset + s2[i].code]++
        }

        return count1.contentEquals(count2)
    }
}