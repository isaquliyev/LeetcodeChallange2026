class Solution744 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {

        var upper = letters.size
        var lower = 0
        var mid: Int
        var ret: Char = letters[0]

        while (upper != lower) {
            mid = (upper + lower) / 2

            if (letters[mid].code <= target.code) lower = mid + 1

            else {
                upper = mid
                ret = letters[mid]
            }
        }
        return ret
    }
}