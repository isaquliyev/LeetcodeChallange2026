import java.util.Collections
import kotlin.math.max

class Solution2975 {
    fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {
        val hSet = getEdges(hFences, m)
        val vSet = getEdges(vFences, n)

        var res: Long = -1

        for (h in hSet) if (vSet.contains(h)) res = max(res, h.toLong())

        if (res < 0) return -1

        return ((res * res) % 1000_000_007).toInt()
    }


    fun getEdges(fencesArray: IntArray, border: Int): Set<Int>  {

        val edges: MutableSet<Int> = mutableSetOf()

        val fences: MutableList<Int> = fencesArray.toMutableList()
        fences.add(1)
        fences.add(border)

        fences.sort()

        for (i in 0 until fences.size)
            for (j in i + 1 until fences.size )
                edges.add(fences[j] - fences[i])

        return edges.toSet()
    }
}