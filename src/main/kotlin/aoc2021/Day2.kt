package aoc2021

import Challenge

object Day2 : Challenge<Int>(2021, 2) {

    override fun solvePartOne(input: List<String>): Int {
        var depth = 0
        var horizontalPos = 0
        input.forEach {
            if(it.startsWith("forward")) {
                horizontalPos += it.replace("forward ", "").toInt()
            } else if(it.startsWith("up")) {
                depth -= it.replace("up ", "").toInt()
            } else if(it.startsWith("down")) {
                depth += it.replace("down ", "").toInt()
            }
        }
        return depth * horizontalPos
    }

    override fun solvePartTwo(input: List<String>) : Int {
        var depth = 0
        var horizontalPos = 0
        var aim = 0
        input.forEach {
            if(it.startsWith("forward")) {
                val value = it.replace("forward ", "").toInt()
                horizontalPos += value
                depth += value * aim
            } else if(it.startsWith("up")) {
                aim -= it.replace("up ", "").toInt()
            } else if(it.startsWith("down")) {
                aim += it.replace("down ", "").toInt()
            }
        }
        return depth * horizontalPos
    }
}