package april

class Solution874 {
    val M = 60013L
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val set = HashSet<Long>()
        for (o in obstacles) set.add(h(o[0].toLong(), o[1].toLong()))
        val d = arrayOf(intArrayOf(0,1), intArrayOf(1,0), intArrayOf(0,-1), intArrayOf(-1,0))
        var x = 0; var y = 0; var dir = 0; var max = 0
        for (c in commands) {
            if (c == -1) { dir = (dir + 1) % 4; continue }
            if (c == -2) { dir = (dir + 3) % 4; continue }
            val v = d[dir]
            repeat(c) {
                val nx = x + v[0]; val ny = y + v[1]
                if (set.contains(h(nx.toLong(), ny.toLong()))) return@repeat
                x = nx; y = ny
            }
            max = maxOf(max, x*x + y*y)
        }
        return max
    }
    fun h(x: Long, y: Long) = x + M * y
}