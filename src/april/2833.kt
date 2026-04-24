package april

class Solution2833 {
    fun furthestDistanceFromOrigin(moves: String): Int {
        val delta = moves.count { it == 'R' } - moves.count { it == 'L' }
        val blanks = moves.count { it == '_' }
        return kotlin.math.abs(delta) + blanks
    }
}