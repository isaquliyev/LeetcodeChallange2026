package march

class Solution1784 {
    fun checkOnesSegment(s: String): Boolean {
        for (i in 0 until s.length - 1) if (s[i] == '0' && s[i + 1] == '1') return false
        return true
    }
}