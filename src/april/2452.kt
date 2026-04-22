package april

class Solution2452 {
    fun twoEditWords(queries: Array<String>, dictionary: Array<String>) =
        queries.filter { q ->
            dictionary.any { s ->
                q.indices.count { q[it] != s[it] } <= 2
            }
        }
}