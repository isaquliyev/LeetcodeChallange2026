import java.util.PriorityQueue
import kotlin.math.cos
import kotlin.math.min

class Solution2976 {

    data class Node(val id: Char, val dist: Long) : Comparable<Node> {
        override fun compareTo(other: Node): Int =
            this.dist.compareTo(other.dist)
    }


    val graph: MutableMap<Char, MutableMap<Char, Int>> = mutableMapOf()

    val cache: MutableMap<Char, MutableMap<Char, Long>> = mutableMapOf()

    fun fillTheGraph(original: CharArray, changed: CharArray, cost: IntArray): Unit {
        for (i in 0 until original.size) {
            if(graph[original[i]] == null)
                graph[original[i]] = mutableMapOf<Char, Int>()

            val valueWillBeAssigned: Int = min(graph[original[i]]?.get(changed[i]) ?: Int.MAX_VALUE, cost[i])

            graph[original[i]]?.put(changed[i], valueWillBeAssigned)
        }
    }



    fun shortestPath(sourceId: Char): MutableMap<Char, Long> {

        if (cache.containsKey(sourceId)) return cache[sourceId]!!

        val pq = PriorityQueue<Node>()
        val dist: MutableMap<Char, Long> = mutableMapOf()

        dist[sourceId] = 0
        pq.add(Node(sourceId, 0))

        while (pq.isNotEmpty()) {
            val u = pq.poll()
            if (u.dist > (dist[u.id] ?: Long.MAX_VALUE)) continue

            val edges = graph[u.id] ?: continue
            for ((target, cost) in edges) {
                val newDist = dist[u.id]!! + cost
                val oldDist = dist[target] ?: Long.MAX_VALUE
                if (newDist < oldDist) {
                    dist[target] = newDist
                    pq.add(Node(target, newDist))
                }
            }
        }

        cache[sourceId] = dist
        return dist
    }


    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {

        fillTheGraph(original, changed, cost)

        var totalCost = 0L

        for (i in source.indices) {
            if (source[i] == target[i]) continue

            val distMap = shortestPath(source[i])
            val sp = distMap[target[i]] ?: return -1
            totalCost += sp
        }

        return totalCost
    }
}
