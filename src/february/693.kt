package february

class Solution663 {
    fun hasAlternatingBits(n: Int): Boolean {

        var direction = n % 2
        // if direction is 1 that means next bit should be 0, vice versa otherwise

        var num = n

        while (n != 0) {
            if (direction == num % 2) {
                num /= 2
                direction = if (direction == 1) 0 else 1
            }
            else return false
        }
        return true
    }
}