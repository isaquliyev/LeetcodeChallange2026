package february

class Solution696 {
    fun countBinarySubstrings(s: String): Int {

        var consecutiveCount = 0
        var zero = 0
        var one = 0

        var directionCount = 0
        val l = s.length

        for (i in 0 until l) {

            if (s[i] == '0') zero++
            else one++

            if (i != l - 1 && s[i] != s[i + 1])
                directionCount++
            else if (i == l - 1) directionCount++

            if (directionCount == 2) {
                consecutiveCount += if (zero > one) one else zero
                println(if (zero > one) one else zero)
                if (s[i] == '1') zero = 0
                else one = 0
                directionCount = 1
            }
        }
        return consecutiveCount
    }
}

