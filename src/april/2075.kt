package april

class Solution2075 {
    fun decodeCiphertext(encodedText: String, rows: Int): String {
        val n = encodedText.length
        if (rows == 1) return encodedText
        val cols = n / rows
        val sb = StringBuilder(n)
        for (c in 0 until cols) {
            var r = 0
            var j = c
            while (r < rows && j < cols) {
                sb.append(encodedText[r * cols + j])
                r++; j++
            }
        }
        while (sb.isNotEmpty() && sb.last() == ' ') sb.deleteCharAt(sb.length - 1)
        return sb.toString()
    }
}