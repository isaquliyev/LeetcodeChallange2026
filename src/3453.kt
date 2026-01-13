class Solution3453 {
    fun separateSquares(squares: Array<IntArray>): Double {

        var minPoint = squares.minOf { it[1].toDouble() }
        var maxPoint = squares.maxOf { it[1].toDouble() + it[2].toDouble() }

        var isMidValid: Boolean = false

        var mid: Double = (maxPoint + minPoint) / 2
        var validMid: Double = 0.0

        repeat(120) {
            var topArea: Double = 0.0
            var bottomArea: Double = 0.0

            for (square in squares) {

                val l: Double = square[2].toDouble()
                val sB: Double = square[1].toDouble()
                val sT: Double = square[1].toDouble() + l


                when {
                    mid in sB .. sT -> {
                        bottomArea += (mid - sB) * l
                        topArea += (sT - mid) * l
                    }
                    mid < sB -> topArea += l * l
                    else -> bottomArea += l * l
                }
            }



            when {
                topArea > bottomArea -> minPoint = (mid + minPoint) / 2
                else -> maxPoint = (maxPoint + mid) / 2
            }
            mid = (maxPoint + minPoint) / 2
        }

        return mid
    }

}