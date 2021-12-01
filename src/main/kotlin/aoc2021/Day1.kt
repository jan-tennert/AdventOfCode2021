package aoc2021

import Challenge

object Day1 : Challenge<Int>(2021, 1) {

    override fun solvePartOne(input: List<String>) : Int {
        var sum = 0
        val numbers = input.filter(String::isNotBlank).map(String::toInt)
        numbers.withIndex().forEach { (index, value) ->
            if(index != 0 && numbers[index - 1] < value) {
                sum++
            }
        }
        return sum
    }

    override fun solvePartTwo(input: List<String>) : Int {
        var sum = 0;
        val numbers = input.filter(String::isNotBlank).map(String::toInt)
        val groups = buildList {
            numbers.withIndex().forEach { (index, value) ->
                if(index !in (numbers.lastIndex - 1)..numbers.lastIndex) {
                    add(listOf(value, numbers[index + 1], numbers[index + 2]))
                }
            }
        }
        groups.withIndex().forEach { (index, value) ->
            if(index != 0) {
                val previous = groups[index - 1]
                if(value.sum() > previous.sum()) {
                    sum++
                }
            }
        }
        return sum
    }

}