package april

class Robot(width: Int, height: Int) {

    private var moved = false
    private var idx = 0
    private val pos = mutableListOf<IntArray>()
    private val dir = mutableListOf<Int>()
    private val toDir = mapOf(0 to "East", 1 to "North", 2 to "West", 3 to "South")

    init {
        for (i in 0 until width) { pos.add(intArrayOf(i, 0)); dir.add(0) }
        for (i in 1 until height) { pos.add(intArrayOf(width - 1, i)); dir.add(1) }
        for (i in width - 2 downTo 0) { pos.add(intArrayOf(i, height - 1)); dir.add(2) }
        for (i in height - 2 downTo 1) { pos.add(intArrayOf(0, i)); dir.add(3) }
        dir[0] = 3
    }

    fun step(num: Int) { moved = true; idx = (idx + num) % pos.size }

    fun getPos(): IntArray = pos[idx]

    fun getDir(): String = if (!moved) "East" else toDir[dir[idx]]!!
}