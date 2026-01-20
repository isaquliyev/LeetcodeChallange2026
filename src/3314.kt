class Solution3314 {
    fun minBitwiseArray(nums: List<Int>): IntArray {
        val ans: MutableList<Int> = mutableListOf()

        var broken = false

        for(num in nums) {
            for (i in 1 .. num) {
                if (i or (i + 1) == num) {
                    ans.add(i)
                    broken = true
                    break
                }
            }
            if (!broken)
                ans.add(-1)
            broken = false
        }
        return ans.toIntArray()
    }
}