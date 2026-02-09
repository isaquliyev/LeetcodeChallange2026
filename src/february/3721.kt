package february

import java.util.ArrayDeque

data class LazyTag(var add: Int = 0) {
    fun isEmpty() = add == 0
    fun combine(other: LazyTag) { add += other.add }
    fun clear() { add = 0 }
}

data class Node(
    var minVal: Int = 0,
    var maxVal: Int = 0,
    var lazy: LazyTag = LazyTag()
)

class SegmentTree(data: IntArray) {
    val n = data.size
    val tree = Array(4 * n) { _ -> Node() }

    init {
        build(data, 1, n, 1)
    }

    private fun build(data: IntArray, l: Int, r: Int, idx: Int) {
        if (l == r) {
            tree[idx].minVal = data[l - 1]
            tree[idx].maxVal = data[l - 1]
            return
        }
        val mid = (l + r) / 2
        build(data, l, mid, idx * 2)
        build(data, mid + 1, r, idx * 2 + 1)
        pushUp(idx)
    }

    private fun pushUp(idx: Int) {
        tree[idx].minVal = minOf(tree[idx * 2].minVal, tree[idx * 2 + 1].minVal)
        tree[idx].maxVal = maxOf(tree[idx * 2].maxVal, tree[idx * 2 + 1].maxVal)
    }

    private fun apply(idx: Int, tag: LazyTag) {
        tree[idx].minVal += tag.add
        tree[idx].maxVal += tag.add
        tree[idx].lazy.combine(tag)
    }

    private fun pushDown(idx: Int) {
        if (tree[idx].lazy.isEmpty()) return
        val tag = tree[idx].lazy.copy()
        apply(idx * 2, tag)
        apply(idx * 2 + 1, tag)
        tree[idx].lazy.clear()
    }

    fun rangeAdd(l: Int, r: Int, value: Int) {
        if (l > r || l > n || r < 1) return
        update(l, r, LazyTag(value), 1, n, 1)
    }

    private fun update(ql: Int, qr: Int, tag: LazyTag, l: Int, r: Int, idx: Int) {
        if (ql > r || qr < l) return
        if (ql <= l && r <= qr) {
            apply(idx, tag)
            return
        }
        pushDown(idx)
        val mid = (l + r) / 2
        if (ql <= mid) update(ql, qr, tag, l, mid, idx * 2)
        if (qr > mid) update(ql, qr, tag, mid + 1, r, idx * 2 + 1)
        pushUp(idx)
    }

    fun findLastZero(start: Int, value: Int): Int {
        if (start > n) return -1
        return find(start, n, value, 1, n, 1)
    }

    private fun find(ql: Int, qr: Int, value: Int, l: Int, r: Int, idx: Int): Int {
        if (l > qr || r < ql || tree[idx].minVal > value || tree[idx].maxVal < value) return -1
        if (l == r) return l
        pushDown(idx)
        val mid = (l + r) / 2
        val rightRes = find(ql, qr, value, mid + 1, r, idx * 2 + 1)
        if (rightRes != -1) return rightRes
        return find(ql, qr, value, l, mid, idx * 2)
    }

    fun queryMin(l: Int, r: Int) = queryMinImpl(l, r, 1, n, 1)

    private fun queryMinImpl(ql: Int, qr: Int, l: Int, r: Int, idx: Int): Int {
        if (ql > r || qr < l) return Int.MAX_VALUE
        if (ql <= l && r <= qr) return tree[idx].minVal
        val mid = (l + r) / 2
        return minOf(queryMinImpl(ql, qr, l, mid, idx * 2), queryMinImpl(ql, qr, mid + 1, r, idx * 2 + 1))
    }
}

class Solution {
    fun longestBalanced(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0

        fun sign(x: Int) = if (x % 2 == 0) 1 else -1

        val prefixSum = IntArray(n)
        prefixSum[0] = sign(nums[0])
        val posMap = HashMap<Int, ArrayDeque<Int>>()
        posMap.getOrPut(nums[0]) { ArrayDeque() }.addLast(1)

        for (i in 1 until n) {
            prefixSum[i] = prefixSum[i - 1]
            val positions = posMap.getOrPut(nums[i]) { ArrayDeque() }
            if (positions.isEmpty()) prefixSum[i] += sign(nums[i])
            positions.addLast(i + 1)
        }

        val segTree = SegmentTree(prefixSum)
        var maxLen = 0

        for (i in 0 until n) {
            val startIdx = i + maxLen
            if (startIdx < n) {
                val lastPos = segTree.findLastZero(startIdx + 1, 0)
                if (lastPos != -1) maxLen = maxOf(maxLen, lastPos - i)
            }

            val num = nums[i]
            val positions = posMap[num]!!
            positions.pollFirst()
            val nextPos = positions.peekFirst() ?: (n + 2)

            val delta = -sign(num)
            if (i + 1 <= nextPos - 1) segTree.rangeAdd(i + 1, nextPos - 1, delta)
        }

        return maxLen
    }
}