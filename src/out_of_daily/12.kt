package out_of_daily

/*

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000

 */

class Solution12 {
    fun intToRoman(num: Int): String {

        var s: String = ""
        var n: Int = num

        s += "M".repeat(n / 1000)
        n %= 1000

        when (n) {
            in 400 until 500 -> s += "CD"
            in 500 until 900 -> {
                s += "D"
                s += "C".repeat((n - 500) / 100)
            }
            in 900 until 1000 -> s += "CM"
            else -> s += "C".repeat(n / 100)
        }

        n %= 100

        when (n) {
            in 90 until 100 -> s += "XC"
            in 50 until 90 -> {
                s += "L"
                s += "X".repeat((n - 50) / 10)
            }
            in 40 until 50 -> s += "XL"
            else -> s += "X".repeat(n / 10)
        }

        n %= 10

        when (n) {
            9 -> s += "IX"
            in 5 until 9 -> {
                s += "V"
                s += "I".repeat(n - 5)
            }
            4 -> s += "IV"
            else -> s += "I".repeat(n)
        }

        return s
    }
}