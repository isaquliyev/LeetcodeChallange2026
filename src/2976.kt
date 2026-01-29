import java.util.PriorityQueue
import kotlin.math.cos
import kotlin.math.min

class Solution {

    data class Node(val id: Char, val dist: Long) : Comparable<Node> {
        override fun compareTo(other: Node): Int =
            this.dist.compareTo(other.dist)
    }


    val graph: MutableMap<Char, MutableMap<Char, Int>> = mutableMapOf()

    fun fillTheGraph(original: CharArray, changed: CharArray, cost: IntArray): Unit {
        for (i in 0 until original.size) {
            if(graph[original[i]] == null)
                graph[original[i]] = mutableMapOf<Char, Int>()

            val valueWillBeAssigned: Int = min(graph[original[i]]?.get(changed[i]) ?: Int.MAX_VALUE, cost[i])

            graph[original[i]]?.put(changed[i], valueWillBeAssigned)
        }
    }



    fun shortestPath(sourceId: Char, targetId: Char): Long {

        if (sourceId == targetId) return 0

        val pq: PriorityQueue<Node> = PriorityQueue<Node>()
        val dist: MutableMap<Char, Long> = mutableMapOf()

        dist[sourceId] = 0
        pq.add(Node(sourceId, 0))

        while (pq.isNotEmpty()) {
            val u = pq.poll()

            if (dist[u.id] != null && u.dist > (dist[u.id] ?: Long.MAX_VALUE)) continue

            val edges = graph[u.id] ?: continue

            for ((target, cost) in edges) {
                val newDist: Long = dist[u.id]!! + cost
                val oldDist: Long = dist[target] ?: Long.MAX_VALUE

                if(newDist < oldDist) {
                    dist[target] = newDist
                    pq.add(Node(target, newDist))
                }
            }
        }

        return dist[targetId] ?: -1
    }



    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {

        fillTheGraph(original = original, changed = changed, cost = cost)

        var totalCost: Long = 0

        for (i in 0 until source.length) {

            val sp = shortestPath(source[i], target[i])
            if (sp == (-1).toLong()) return -1
            totalCost += sp


        }

        return totalCost
    }
}
