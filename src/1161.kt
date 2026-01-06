import java.util.LinkedList
import java.util.Queue

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

/*
        Level-order representation:
              1
            /   \
           7     0
          / \
         7  -8
     */

class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        var maxSum: Int = root?.`val` ?: 0

        val bfsQueue: Queue<TreeNode> = LinkedList<TreeNode>()
        var howManyShouldRemove: Int = 1
        var minLevel: Int = 1
        var currentLevel: Int = 0

        bfsQueue.add(root)


        while (bfsQueue.isNotEmpty()) {
            var tempSum: Int = 0

            var willIncrease: Int = 0

            currentLevel++



            while (howManyShouldRemove-- > 0) {
                val node: TreeNode = bfsQueue.remove()
                tempSum += node.`val`

                if (node.right != null) {
                    bfsQueue.add(node.right)
                    willIncrease++
                }
                if (node.left != null) {
                    bfsQueue.add(node.left)
                    willIncrease++
                }
            }

            howManyShouldRemove = willIncrease

            if (tempSum > maxSum) {
                maxSum = tempSum
                minLevel = currentLevel
            }

        }

        return minLevel
    }
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}