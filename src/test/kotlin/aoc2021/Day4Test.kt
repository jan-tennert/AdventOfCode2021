package aoc2021

import getInputFile
import org.junit.Test
import java.nio.file.Path
import kotlin.io.path.readLines
import kotlin.test.assertEquals

class Day4Test {

    @Test
    fun `test day4 part one`() {
        val input = getInputFile(2021, 4)
        assertEquals(Day4.solvePartOne(input.readLines()), 4512)
    }

    @Test
    fun `test day4 part two`() {
        val input = getInputFile(2021, 4, true)
        println(Day4.solvePartTwo(input.readLines()))
        assertEquals(Day4.solvePartTwo(input.readLines()), 1924)
    }

}