package february

import java.util.TreeMap


class Container(private val k: Int) {

    private val st1 = TreeMap<Int, Int>()
    private val st2 = TreeMap<Int, Int>()

    private var st1Size = 0
    private var st2Size = 0
    private var sm = 0L

    private fun addOne(map: TreeMap<Int, Int>, key: Int) {
        map[key] = map.getOrDefault(key, 0) + 1
    }

    private fun removeOne(map: TreeMap<Int, Int>, key: Int) {
        val cnt = map[key]!!
        if (cnt == 1) {
            map.remove(key)
        } else {
            map[key] = cnt - 1
        }
    }

    private fun adjust() {
        while (st1Size < k && st2.isNotEmpty()) {
            val x = st2.firstKey()
            addOne(st1, x)
            st1Size++
            sm += x
            removeOne(st2, x)
            st2Size--
        }

        while (st1Size > k) {
            val x = st1.lastKey()
            addOne(st2, x)
            st2Size++
            removeOne(st1, x)
            st1Size--
            sm -= x
        }
    }

    fun add(x: Int) {
        if (st2.isNotEmpty() && x >= st2.firstKey()) {
            addOne(st2, x)
            st2Size++
        } else {
            addOne(st1, x)
            st1Size++
            sm += x
        }
        adjust()
    }

    fun erase(x: Int) {
        when {
            st1.containsKey(x) -> {
                removeOne(st1, x)
                st1Size--
                sm -= x
            }
            st2.containsKey(x) -> {
                removeOne(st2, x)
                st2Size--
            }
        }
        adjust()
    }

    fun sum(): Long = sm
}

class Solution3013 {

    fun minimumCost(nums: IntArray, k: Int, dist: Int): Long {
        val n = nums.size
        val cnt = Container(k - 2)

        for (i in 1 until k - 1) {
            cnt.add(nums[i])
        }

        var ans = cnt.sum() + nums[k - 1]

        for (i in k until n) {
            val j = i - dist - 1
            if (j > 0) {
                cnt.erase(nums[j])
            }
            cnt.add(nums[i - 1])
            ans = minOf(ans, cnt.sum() + nums[i])
        }

        return ans + nums[0]
    }
}
