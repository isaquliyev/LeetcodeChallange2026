package february

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Solution1404Test {

    private lateinit var solution: Solution1404

    @BeforeAll
    fun setup() {
        solution = Solution1404()
    }

    @Test
    fun `increment without carry`() {
        val input = mutableListOf('1', '0', '1') // 5
        solution.addOne(input)
        assertEquals(listOf('1', '1', '0'), input) // 6
    }

    @Test
    fun `increment single zero`() {
        val input = mutableListOf('0')
        solution.addOne(input)
        assertEquals(listOf('1'), input)
    }

    @Test
    fun `increment single one`() {
        val input = mutableListOf('1')
        solution.addOne(input)
        assertEquals(listOf('1', '0'), input)
    }

    @Test
    fun `increment all ones`() {
        val input = mutableListOf('1', '1', '1')
        solution.addOne(input)
        assertEquals(listOf('1', '0', '0', '0'), input)
    }

    @Test
    fun `increment with multiple trailing ones`() {
        val input = mutableListOf('1', '0', '1', '1', '1') // 23
        solution.addOne(input)
        assertEquals(listOf('1', '1', '0', '0', '0'), input) // 24
    }

    @Test
    fun `carry propagates through entire array`() {
        val input = mutableListOf('1', '1', '1', '1')
        solution.addOne(input)
        assertEquals(listOf('1', '0', '0', '0', '0'), input)
    }
}