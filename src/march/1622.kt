package march

class Fancy {

    companion object {
        const val MOD = 1_000_000_007
    }

    private val v = mutableListOf<Int>()
    private val a = mutableListOf(1)
    private val b = mutableListOf(0)

    fun append(value: Int) {
        v.add(value)
        a.add(a.last())
        b.add(b.last())
    }

    fun addAll(inc: Int) {
        val i = b.lastIndex
        b[i] = (b[i] + inc) % MOD
    }

    fun multAll(m: Int) {
        val ai = a.lastIndex
        val bi = b.lastIndex

        a[ai] = ((a[ai].toLong() * m) % MOD).toInt()
        b[bi] = ((b[bi].toLong() * m) % MOD).toInt()
    }

    fun getIndex(idx: Int): Int {
        if (idx >= v.size) return -1

        val ao = ((inv(a[idx]).toLong() * a.last()) % MOD).toInt()

        val bo = (
                (b.last().toLong()
                        - (b[idx].toLong() * ao) % MOD
                        + MOD) % MOD
                ).toInt()

        return (((ao.toLong() * v[idx]) % MOD + bo) % MOD).toInt()
    }

    private fun quickMul(x: Int, y: Int): Int {
        var exp = y
        var cur = x.toLong()
        var result = 1L

        while (exp != 0) {
            if ((exp and 1) != 0) {
                result = (result * cur) % MOD
            }
            cur = (cur * cur) % MOD
            exp = exp shr 1
        }

        return result.toInt()
    }

    private fun inv(x: Int): Int = quickMul(x, MOD - 2)

}