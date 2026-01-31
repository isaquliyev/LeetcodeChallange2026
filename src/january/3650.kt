import java.util.PriorityQueue

class Solution3650 {

    data class Node(val id: Int, val dist: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int = this.dist - other.dist
    }


    fun minCost(n: Int, edges: Array<IntArray>): Int {

        val pq: PriorityQueue<Node> = PriorityQueue()
        val dist: IntArray = IntArray(n) {
            Int.MAX_VALUE
        }

        val allEdges = addReversedEdges(edges)


        val graph: List<MutableList<IntArray>> =
            List(n) {
                mutableListOf()
            }

        for (edge in allEdges) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2]

            graph[u].add(intArrayOf(v, w))
        }

        dist[0] = 0

        pq.add(Node(0, 0))

        while (pq.isNotEmpty()) {
            val u = pq.poll()

            if (u.dist > dist[u.id]) continue

            for (edge in graph[u.id]) {
                val newDist = dist[u.id] + edge[1]
                if (newDist < dist[edge[0]]) {
                    dist[edge[0]] = newDist
                    pq.add(Node(edge[0], newDist))
                }
            }
        }


        return if(dist[n-1] == Int.MAX_VALUE) -1 else dist[n-1]
    }

    fun addReversedEdges(edges: Array<IntArray>): MutableList<IntArray> {

        val edgesWithReverse: MutableList<IntArray> = mutableListOf()

        for (edge in edges) {
            edgesWithReverse.add(edge)
            edgesWithReverse.add(intArrayOf(edge[1], edge[0], 2 * edge[2]))
        }

        return edgesWithReverse
    }
}