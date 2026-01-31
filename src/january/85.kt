import java.util.Stack
import kotlin.math.max

class Solution85 {

    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val n = matrix.size
        val m = matrix[0].size

        var maxArea = 0
        val heights = IntArray(m)
        val stack = Stack<Int>()

        for (i in 0 until n) {
            for (j in 0 until m)
                heights[j] = if (matrix[i][j] == '1') heights[j] + 1 else 0

            stack.push(-1)

            for (j in 0 until m) {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[j]) {
                    val h = heights[stack.pop()]
                    val w = j - stack.peek() - 1
                    maxArea = max(maxArea, h * w)
                }
                stack.push(j)
            }

            while (stack.peek() != -1) {
                val h = heights[stack.pop()]
                val w = m - stack.peek() - 1
                maxArea = max(maxArea, h * w)
            }

            stack.clear()
        }

        return maxArea
    }
}