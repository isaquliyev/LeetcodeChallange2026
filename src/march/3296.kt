package march

class Solution3296 {

    companion object {
        const val EPS = 1e-7
    }

    fun minNumberOfSeconds(mountainHeight: Int, workerTimes: IntArray): Long {
        var maxWorkerTimes = 0
        for (t in workerTimes)
            maxWorkerTimes = maxOf(maxWorkerTimes, t)

        var l = 1L
        var r = maxWorkerTimes.toLong() * mountainHeight * (mountainHeight + 1) / 2
        var ans = 0L

        while (l <= r) {
            val mid = (l + r) / 2
            var cnt = 0L

            for (t in workerTimes) {
                val work = mid / t
                val k = ((-1.0 + kotlin.math.sqrt(1 + work * 8.0)) / 2 + EPS).toLong()
                cnt += k
            }

            if (cnt >= mountainHeight) {
                ans = mid
                r = mid - 1
            } else l = mid + 1
        }
        return ans
    }
}