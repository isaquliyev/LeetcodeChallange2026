package april

class Solution1855 {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        val m = nums2.size
        var dis = 0
        var j = 0

        for (i in 0 until n) {
            if (j < i) j = i + 1

            while (j < m && nums2[j] >= nums1[i]) {
                j++
            }

            dis = maxOf(dis, j - i - 1)
        }

        return dis
    }
}