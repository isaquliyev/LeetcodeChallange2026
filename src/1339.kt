import com.sun.source.tree.Tree
import java.util.LinkedList
import java.util.Stack
import kotlin.math.abs

class Solution1339 {

    val MOD = 1_000_000_007

    fun maxProduct(root: TreeNode?): Int {



        var maxProd: Long = 0
        var prevTop: Long = 0

        var node: TreeNode? = root

        while (node != null) {
            val left = getSum(node.left)
            val right = getSum(node.right)

            var tempProd: Long= 0

            if (left >= right /* node.`val` */) {
                tempProd = left * (prevTop + right + node.`val`)
                prevTop += right + node.`val`
                node = node.left
            } else {
                tempProd = right * (prevTop + left + node.`val`)
                //println("left: $left, root: ${root?.`val`}, prevProd: $prevTop")
                prevTop += + left + node.`val`
                //println("prevProd: $prevTop // after")
                node = node.right
            }

            if (tempProd > maxProd) maxProd = tempProd
            else break

        }

        return (maxProd % MOD).toInt()
    }

    fun getSum(root: TreeNode?): Long {
        if (root == null) return 0
        return root.`val` + getSum(root.left) + getSum(root.right)
    }
}