package aoc2021

import Challenge

object Day3 : Challenge<Int>(2021, 3) {

    override fun solvePartOne(input: List<String>): Int {
        var gamma = ""
        var epsilon = ""
        val size = input[0].length

        val nulls = IntArray(size)
        val ones = IntArray(size)
        for (s in input) {
            for ((index, char) in s.withIndex()) {
                if(char == '1') ones[index] = ones[index].plus(1) ?: 1
                if(char == '0') nulls[index] = nulls[index].plus(1) ?: 1
            }
        }
        for(i in 0 until size) {
            if(ones[i] > nulls[i]) {
                gamma += "1"
                epsilon += "0"
            } else {
                gamma += "0"
                epsilon += "1"
            }
        }
        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
    }

    override fun solvePartTwo(input: List<String>): Int {
        return insertNameHere(input, true) * insertNameHere(input, false)
    }

    private fun insertNameHere(input: List<String>, common: Boolean): Int {
        var numbers = input.filter(String::isNotBlank)
        val size = numbers[0].length
        var nulls = countZerosAndOnes(numbers).first
        var ones = countZerosAndOnes(numbers).second
        for (index in 0 until size) {
            numbers = numbers.filter {
                var c = nulls[index] == ones[index]
                c = if(common) {
                    c && it[index] == '1' || it[index] == '1' && nulls[index] < ones[index] || it[index] == '0' && nulls[index] > ones[index]
                } else {
                    c && it[index] == '0' || it[index] == '1' && nulls[index] > ones[index] || it[index] == '0' && nulls[index] < ones[index]
                }
                c
            }
            nulls = countZerosAndOnes(numbers).first
            ones = countZerosAndOnes(numbers).second
            if(numbers.size == 1) break
        }
        return numbers[0].toInt(2)
    }

    private fun countZerosAndOnes(input: List<String>): Pair<IntArray, IntArray> {
        val size = input[0].length
        val nulls = IntArray(size)
        val ones = IntArray(size)

        for (s in input) {
            for ((index, char) in s.withIndex()) {
                if(char == '1') ones[index] = ones[index].plus(1)
                if(char == '0') nulls[index] = nulls[index].plus(1)
            }
        }
        return nulls to ones
    }

}