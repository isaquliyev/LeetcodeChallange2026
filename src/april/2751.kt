package april

class Solution2751 {
    fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
        val n = positions.size
        val idx = (0 until n).sortedBy { positions[it] }
        val stack = ArrayDeque<Int>()

        for (i in idx) {
            if (directions[i] == 'R') stack.addLast(i)
            else {
                while (stack.isNotEmpty() && healths[i] > 0) {
                    val j = stack.removeLast()
                    when {
                        healths[j] > healths[i] -> {
                            healths[j]--
                            healths[i] = 0
                            stack.addLast(j)
                        }
                        healths[j] < healths[i] -> {
                            healths[i]--
                            healths[j] = 0
                        }
                        else -> {
                            healths[i] = 0
                            healths[j] = 0
                        }
                    }
                }
            }
        }
        return (0 until n).filter { healths[it] > 0 }.map { healths[it] }
    }
}