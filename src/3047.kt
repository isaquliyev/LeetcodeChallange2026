import kotlin.math.max
import kotlin.math.min

class Solution3047 {
    fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
        var maxSide: Int = 0

        val size = bottomLeft.size

        for (i in 0 until size) {
            for (j in i + 1 until size) {
                val side = findAreaByGivenTwoPoints(firstBL = bottomLeft[i], firstTL = topRight[i], secondBL = bottomLeft[j], secondTL = topRight[j])
                maxSide = maxOf(maxSide, side)
            }
        }

        return (maxSide.toLong() * maxSide.toLong())
    }


    fun findAreaByGivenTwoPoints(firstBL: IntArray, firstTL: IntArray, secondBL: IntArray, secondTL: IntArray): Int {
        val width = min(firstTL[0], secondTL[0]) -
                max(firstBL[0], secondBL[0])
        val height = min(firstTL[1], secondTL[1]) -
                max(firstBL[1], secondBL[1])

        return min(height, width)
    }
}