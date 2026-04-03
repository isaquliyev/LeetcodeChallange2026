package april

class Solution3661 {

    fun maxWalls(robots: IntArray, distance: IntArray, walls: IntArray): Int {
        val n = robots.size
        val left = IntArray(n)
        val right = IntArray(n)
        val num = IntArray(n)
        val robotsToDistance = HashMap<Int, Int>()

        for (i in 0 until n) {
            robotsToDistance[robots[i]] = distance[i]
        }

        robots.sort()
        walls.sort()

        for (i in 0 until n) {
            val pos1 = upperBound(walls, robots[i])

            val leftPos = if (i >= 1) {
                val leftBound = maxOf(
                    robots[i] - robotsToDistance[robots[i]]!!,
                    robots[i - 1] + 1
                )
                lowerBound(walls, leftBound)
            } else {
                lowerBound(
                    walls,
                    robots[i] - robotsToDistance[robots[i]]!!
                )
            }
            left[i] = pos1 - leftPos

            val rightPos = if (i < n - 1) {
                val rightBound = minOf(
                    robots[i] + robotsToDistance[robots[i]]!!,
                    robots[i + 1] - 1
                )
                upperBound(walls, rightBound)
            } else {
                upperBound(
                    walls,
                    robots[i] + robotsToDistance[robots[i]]!!
                )
            }
            val pos2 = lowerBound(walls, robots[i])
            right[i] = rightPos - pos2

            if (i == 0) continue

            val pos3 = lowerBound(walls, robots[i - 1])
            num[i] = pos1 - pos3
        }

        var subLeft = left[0]
        var subRight = right[0]

        for (i in 1 until n) {
            val currentLeft = maxOf(
                subLeft + left[i],
                subRight - right[i - 1] + minOf(left[i] + right[i - 1], num[i])
            )
            val currentRight = maxOf(
                subLeft + right[i],
                subRight + right[i]
            )
            subLeft = currentLeft
            subRight = currentRight
        }

        return maxOf(subLeft, subRight)
    }

    private fun lowerBound(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (arr[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    private fun upperBound(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (arr[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}