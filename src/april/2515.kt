package april

import kotlin.math.abs

class Solution2515 {
    fun closestTarget(words: Array<String>, target: String, startIndex: Int): Int {
        return words.indices.filter { words[it] == target }
            .minOfOrNull { minOf(abs(it - startIndex), words.size - abs(it - startIndex)) } ?: -1
    }
}