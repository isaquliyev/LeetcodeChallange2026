class Solution3454 {
    fun separateSquares(squares: Array<IntArray>): Double {

        val xS: MutableSet<Int> = mutableSetOf<Int>()
        val events: MutableList<IntArray> = mutableListOf<IntArray>()


        for ((x, y, size) in squares) {

            xS.add(x)
            xS.add(x + size)

            events.add(intArrayOf(y, x, x + size, 1))
            events.add(intArrayOf(y + size, x, x + size, -1))
        }

        val sortedXS = xS.sorted()
        val sortedEvents = events.sortedBy { it[0] }
        val st = SegmentTree(sortedXS)

        var area: Double = 0.0
        var previousBreakpoint : Int = sortedEvents[0][0]

        for ((y, sql, sqr, op) in sortedEvents) {
            area += st.query() * (y - previousBreakpoint)
            st.update(sql, sqr, 0, st.n - 1, op, 0)
            previousBreakpoint = y
        }

        var accumulatedArea = 0
        previousBreakpoint = sortedEvents[0][0]

        for ((y, sql, sqr, op) in sortedEvents) {
            val combinedWidth = st.query()
            val currentArea = combinedWidth * (y - previousBreakpoint)
            if (accumulatedArea + currentArea >= area / 2) {
                return previousBreakpoint + ((area / 2) - accumulatedArea) / combinedWidth
            }
            accumulatedArea += currentArea
            st.update(sql, sqr, 0, st.n - 1, op, 0)
            previousBreakpoint = y
        }
        return 0.0
    }
}

class SegmentTree {

    val xS: List<Int>
    val n: Int
    val count: IntArray
    val covered: IntArray

    constructor(xS: List<Int>) {
        this.xS = xS
        this.n = xS.size - 1
        this.count = IntArray(4 * n)
        this.covered = IntArray(4 * n)
    }

    fun update(sql: Int, sqr: Int, l: Int, r: Int, op: Int, pos: Int) {
        if (sqr <= this.xS[l] || sql >= this.xS[r + 1]) return // no overlap
        if (sql <= this.xS[l] && sqr >= this.xS[r + 1]) this.count[pos] += op // full overlap

        /// partial overlap
        else {
            val mid: Int = (l + r) / 2
            this.update(sql, sqr, l, mid, op, pos * 2 + 1)
            this.update(sql, sqr, mid + 1, r, op, pos * 2 + 2)
        }

        when {
            this.count[pos] > 0 -> this.covered[pos] = this.xS[r + 1] - this.xS[l]
            l == r -> this.covered[pos] = 0
            else -> this.covered[pos] = this.covered[pos * 2 + 1] + this.covered[pos * 2 + 2]
        }
    }

    fun query(): Int = this.covered[0]
}