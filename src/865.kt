import com.sun.source.tree.Tree
import kotlin.math.max

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
class Solution865 {
    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {

        var depth: Int = maxDepth(root)

        var node: TreeNode? = root

        while (depth > 0) {

            val left: TreeNode? = node?.left
            val right: TreeNode? = node?.right

            val leftDepth = maxDepth(left)
            val rightDepth = maxDepth(right)

            if (leftDepth == (depth - 1) && rightDepth == (depth - 1)) {
                return node
            } else {
                node = if (leftDepth > rightDepth) left else right
            }

            depth--
        }

        return root
    }

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