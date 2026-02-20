package february

class Solution761 {
    fun makeLargestSpecial(s: String): String {
        var balance = 0
        var start = 0

        return buildList {
            s.forEachIndexed { i, c ->
                balance += if (c == '1') 1 else -1
                if (balance == 0) {
                    add("1${makeLargestSpecial(s.substring(start + 1, i))}0")
                    start = i + 1
                }
            }
        }.sortedDescending().joinToString("")
    }
}