package february

import kotlin.math.max

class Solution868 {
    fun binaryGap(n: Int): Int {

        var ans = 0
        var counter = 0
        var indicator = 0
        var num = n

        while(num != 1) {

            if (num % 2 == 1) indicator++

            if (indicator == 1) counter++
            if (indicator == 2) {
                ans = max(ans, counter)
                counter = 0
                indicator = 0
            }
            num = num shr 1
        }
        return ans
    }
}