package february

class Solution401 {
    fun readBinaryWatch(turnedOn: Int): List<String> {
        val l: MutableList<String> = mutableListOf();
        for (i in 0 until 12) for (j in 0 until 60) if (turnedOn == Integer.bitCount(i) + Integer.bitCount(j)) l.add("$i:" + if (j < 10) "0$j" else j)
        return l.toList()
    }
}