/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution1382 {
    val arr = mutableListOf<TreeNode>()

    fun balanceBST(root: TreeNode?): TreeNode? {
        traverseInOrder(root)
        return build(0, arr.size - 1)
    }

    fun traverseInOrder(root: TreeNode?) {
        if (root == null) return
        traverseInOrder(root.left)
        arr.add(root)
        traverseInOrder(root.right)
    }

    fun build(l: Int, r: Int): TreeNode? {
        if (l > r) return null

        val mid = (l + r) ushr 1
        val node = arr[mid]

        node.left = build(l, mid - 1)
        node.right = build(mid + 1, r)

        return node
    }
}
