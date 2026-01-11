import java.util.Stack
import kotlin.math.max

class Solution85 {

    fun maximalRectangle(matrix: Array<CharArray>): Int {

        val n = matrix.size
        val m = matrix[0].size
        var maxArea: Int = 0

        val intMatrix: Array<IntArray> = Array(n) { IntArray(m) }

        for (i in 0 until n) {
            for (j in 0 until m)
                intMatrix[i][j] =
                    if (i == 0) matrix[i][j].digitToInt()
                        else if (matrix[i][j] == '0') 0
                            else intMatrix[i - 1][j] + 1
        }

        val stack: Stack<Int> = Stack()

        for (row in intMatrix) {
            stack.push(-1)
            for (j in 0 until m) {
                while (stack.peek() != -1 && row[stack.peek()] >= row[j]) {
                    val h: Int = row[stack.pop()]
                    val w: Int = j - stack.peek() - 1
                    maxArea = max(maxArea, h * w)
                }
                stack.push(j)

            }

            while (stack.peek() != -1) {
                val h = row[stack.pop()]
                val w = m - stack.peek() - 1
                maxArea = max(maxArea, h * w)
            }


            stack.clear()
        }


        return maxArea
    }
}