package february

import TreeNode

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {

        if (root == null) return true

        val depth = maxDepth(root)

        if ((root.left == null || root.right == null) && depth >= 2) return false
        else return isBalanced(root.left) && isBalanced(root.right)

        //return !(depth - maxDepth(root.left) > 2 || depth - maxDepth(root.right) > 2)
    }

    fun hasChild(root: TreeNode?): Boolean = root?.left != null || root?.right != null
    fun hasGrandChild(root: TreeNode?): Boolean = hasChild(root?.left) || hasChild(root?.right)

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