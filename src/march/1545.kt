package march

import javax.xml.transform.Source

class Solution1545 {

    fun findKthBit(n: Int, k: Int): Char {
        val s = findString(n)
        //println(s)
        return s[k - 1]
    }

    fun findString(n: Int): String {
        if(n == 1) return "0"

        val f = findString(n - 1)
        //println(f)

        return  f + "1" + reverseInvert(f)
    }

    fun reverseInvert(s: String): String {
        val arr: MutableList<Char> = mutableListOf()
        for (c in s) {
            if(c == '1') arr.add('0')
            else arr.add('1')
        }
        //arr.reversed()
        return arr.reversed().joinToString("")
    }
}

fun main() {
    val solution: Solution1545 = Solution1545()

    println(solution.findKthBit(20, 1048575))
}