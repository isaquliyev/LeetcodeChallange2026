import kotlin.math.min

class Solution2943 {
    fun maximizeSquareHoleArea(n: Int, m: Int, hBars: IntArray, vBars: IntArray): Int {

        var hit = 1
        var maxHit = hit
        var vit = 1
        var maxVit = vit


        val sortedHBars = hBars.sorted()
        val soredVBars = vBars.sorted()

        for (i in 1 until sortedHBars.size) {
            if (sortedHBars[i] == sortedHBars[i - 1] + 1) {
                hit++
                if (hit > maxHit) maxHit = hit
            } else hit = 1

        }

        for (i in 1 until soredVBars.size) {
            if (soredVBars[i] == soredVBars[i - 1] + 1) {
                vit++
                if (vit > maxVit) maxVit = vit
            }
            else vit = 1
        }

        return (min(maxHit, maxVit) + 1) * (min(maxHit, maxVit) + 1)
    }
}