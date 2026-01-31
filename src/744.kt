class Solution744 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {

        val s: Set<Char> = letters.toSet()

        for (letter in s) {
            if (letter.code > target.code) return letter
        }

        return letters[0]

    }
}