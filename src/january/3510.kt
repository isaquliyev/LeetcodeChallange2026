import java.util.PriorityQueue

class Node(var value: Long, val left: Int) {
    var prev: Node? = null
    var next: Node? = null
}

data class PQItem(val a: Node, val b: Node, val cost: Long) : Comparable<PQItem> {
    override fun compareTo(o: PQItem) =
        if (cost == o.cost) a.left - o.a.left else if (cost < o.cost) -1 else 1
}

class Solution3510 {
    fun minimumPairRemoval(nums: IntArray): Int {
        val pq = PriorityQueue<PQItem>()
        val merged = BooleanArray(nums.size)
        var dec = 0; var ans = 0

        var head = Node(nums[0].toLong(), 0)
        var cur = head

        for (i in 1 until nums.size) {
            val n = Node(nums[i].toLong(), i)
            cur.next = n; n.prev = cur
            pq += PQItem(cur, n, cur.value + n.value)
            if (nums[i - 1] > nums[i]) dec++
            cur = n
        }

        while (dec > 0) {
            val (f, s, c) = pq.poll()
            if (merged[f.left] || merged[s.left] || f.value + s.value != c) continue

            ans++
            if (f.value > s.value) dec--

            val p = f.prev; val n = s.next
            f.next = n; n?.prev = f

            p?.let {
                dec += when {
                    it.value > f.value && it.value <= c -> -1
                    it.value <= f.value && it.value > c -> 1
                    else -> 0
                }
                pq += PQItem(it, f, it.value + c)
            }

            n?.let {
                dec += when {
                    s.value > it.value && c <= it.value -> -1
                    s.value <= it.value && c > it.value -> 1
                    else -> 0
                }
                pq += PQItem(f, it, c + it.value)
            }

            f.value = c
            merged[s.left] = true
        }
        return ans
    }
}
