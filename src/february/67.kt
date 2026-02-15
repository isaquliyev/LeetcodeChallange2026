package february

import kotlin.math.abs

class Solution67 {
    fun addBinary(a: String, b: String): String {

        val l1: Int = a.length
        val l2: Int = b.length

        val longerString: String = if (l1 > l2) a else b
        val shorterString: String = if (l1 > l2) b else a

        val diff: Int = abs(l1 - l2)
        val ans: MutableList<Char> = mutableListOf()

        for (i in 0 until diff) {
            ans.add(longerString[i])
        }

        for (i in 0 until shorterString.length) {
            if (shorterString[i] == '0' && longerString[diff + i] == '0')
                ans.add('0')
            else if (shorterString[i] == '1' && longerString[diff + i] == '1') {
                turnLastZeroToOne(ans)
                ans.add('0')
            }
            else {
                ans.add('1')
            }
        }
        return ans.joinToString("")
    }

    fun turnLastZeroToOne(candidate: MutableList<Char>): Unit {

        if (candidate.isEmpty()) {
            candidate.add('1')
            return
        }

        val l: Int = candidate.size

        var isBroken: Boolean = false

        for (i in (l - 1) downTo 0) {
            if (candidate[i] == '0') {
                candidate.removeAt(i)
                isBroken = true
                break
            }
        }

        if (isBroken) {
            candidate.add('1')
        } else {
            addOneAtStartTurnAllToZero(candidate)
        }
    }

    fun addOneAtStartTurnAllToZero(candidate: MutableList<Char>) {
        for (i in candidate.indices) {
            candidate[i] = '0'
        }

        candidate.add(0, '1')
    }
}