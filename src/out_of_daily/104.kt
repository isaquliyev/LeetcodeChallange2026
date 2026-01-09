package out_of_daily

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
class Solution104 {
    fun maxDepth(root: TreeNode?): Int {

        if (root == null) return 0
        if (root.left == null && root.right == null) return 1

        val leftSide: Int = maxDepth(root.left)
        val rightSide: Int = maxDepth(root.right)

        return if (leftSide > rightSide)
            1 + leftSide
        else 1 + rightSide

    }
}