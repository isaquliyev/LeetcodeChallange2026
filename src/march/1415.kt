package march

class Solution1415 {
    fun getHappyString(n: Int, k: Int): String {
        var m = k - 1
        val chr: MutableList<Int>  = mutableListOf()
        var counter = 0

        while (counter < n - 1) {

            if (m % 2 == 0) {
                chr.add(0, 0)
            } else {
                chr.add(0, 1)
            }
            m /= 2

            counter++
        }
        chr.add(0, m)

        return constructString(chr)
    }

    fun constructString(intArr: MutableList<Int>): String {
        val chr: MutableList<Char> = mutableListOf()
        for (i in 0 until intArr.size) {
            if (i == 0) {
                when (intArr[i]) {
                    0 -> chr.add('a')
                    1 -> chr.add('b')
                    2 -> chr.add('c')
                    else -> return ""
                }
                continue
            }
            when (chr[i - 1]) {
                'a' -> chr.add(if(intArr[i] == 1) 'c' else 'b')
                'b' -> chr.add(if(intArr[i] == 1) 'c' else 'a')
                'c' -> chr.add(if(intArr[i] == 1) 'b' else 'a')
            }
        }

        return chr.joinToString("")
    }
}

fun main() {
    val solution: Solution1415 = Solution1415()


    println(solution.getHappyString(3, 9))
    println(solution.getHappyString(3, 10))
    println(solution.getHappyString(3, 1))
}