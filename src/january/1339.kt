import kotlin.math.abs

class Solution1339 {

    val MOD = 1_000_000_007

    val list: MutableList<Long> = mutableListOf()

    fun maxProduct(root: TreeNode?): Int {

        val wholeSum: Long = getSum(root)
        val doubleSum = wholeSum.toDouble()

        val sortedList = list.sortedBy {
            x -> abs(x - doubleSum / 2)
        }.reversed()

        val nearestToMid: Long = sortedList.last()

        return (((wholeSum - nearestToMid) * (nearestToMid)) % MOD).toInt()
    }

    fun getSum(root: TreeNode?): Long {
        if (root == null) return 0

        val left: Long = getSum(root.left)
        val right: Long = getSum(root.right)

        if (left != 0.toLong()) list.add(left)
        if (right != 0.toLong()) list.add(right)

        return root.`val` + left + right
    }
}