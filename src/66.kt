class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val length : Int = digits.size;
        var i : Int = 1;
        if (digits[length - i] != 9) {
            digits[length - i]++
            return digits
        }
        try {
            while (digits[length - i] == 9) {
                digits[length - i++] = 0
            }
        } catch (e: Exception) {
            return intArrayOf(1, *digits);
        }
        digits[length - i]++
        return digits

    }

}