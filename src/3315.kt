import java.lang.Math.pow
import kotlin.math.pow

class Solution3315 {
    fun minBitwiseArray(nums: List<Int>): IntArray {

        val ans: IntArray = IntArray(nums.size)

        for (i in 0 until nums.size) {
            var n = nums[i]
            var count = 0
            while(n % 2 != 0) {
                n = n shr 1
                count++
            }

            if (count == 0) {
                ans[i] = -1
                continue
            }
            ans[i] = ((n shl count) + 2.0.pow(count - 1).toInt() - 1)
        }

        return ans
    }
}