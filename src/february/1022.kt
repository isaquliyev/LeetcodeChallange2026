package february

import TreeNode

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
class Solution1022 {
    fun sumRootToLeaf(root: TreeNode?): Int {
        return dfs(root, 0)
    }

    fun dfs(node: TreeNode?, value: Int): Int {
        if (node == null) return 0

        val newValue = value * 2 + node.`val`
        if (node.left == null && node.right == null) return newValue
        return dfs(node.left, newValue) + dfs(node.right, newValue)
    }
}