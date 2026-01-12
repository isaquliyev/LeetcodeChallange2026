import kotlin.math.abs
import kotlin.math.max

class Solution1266 {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {

        var time: Int = 0

        for (i in 1 until points.size)
            time += max(abs(points[i][0] - points[i - 1][0]), abs(points[i][1] - points[i - 1][1]))


        return time
    }
}