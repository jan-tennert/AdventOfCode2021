package aoc2021

import Challenge

object Day4 : Challenge<Int>(2021, 4) {

    override fun solvePartOne(input: List<String>): Int {
        return getWinners(input)[0]
    }

    override fun solvePartTwo(input: List<String>): Int {
        return getWinners(input).last()
    }

    private fun getWinners(input: List<String>): List<Int> {
        val numbers = input[0].split(",").map(String::toInt)
        println(numbers)
        val rawBoards = input.subList(1, input.size)
        var rowIndex = 0
        var boardIndex = 0
        val boards = mutableListOf<Board>()
        val winners = mutableListOf<Int>()
        for (rawBoard in rawBoards) {
            if(rawBoard.isBlank()) continue
            val row = rawBoard.split(Regex(" +")).filter(String::isNotBlank).map(String::toInt)
            val board = boards.getOrNull(boardIndex) ?: Board()
            row.withIndex().forEach { (index, value) ->
                board[rowIndex, index] = value
            }
            if(boards.getOrNull(boardIndex) == null) boards.add(board)
            if(rowIndex == 4) {
                rowIndex = 0
                boardIndex++
            } else {
                rowIndex++
            }
        }
        for(i in numbers.indices) {
            val bingoNumbers = numbers.subList(0, i + 1)
            boards.toMutableList().forEach {
                if(it.isBingo(bingoNumbers)) {
                    val lastNumber = bingoNumbers.last()
                    val remainingNumbersSum = it.grid.flatten().also { println(it) }.filter { n -> n !in bingoNumbers }.also { println(it) }.sum()
                    winners.add(lastNumber * remainingNumbersSum)
                    boards.remove(it)
                }
            }
        }
        return winners
    }

    class Board {
        val grid = Array(5) { Array(5) { 0 } }

        operator fun get(x: Int, y: Int): Int {
            return grid[x][y]
        }

        operator fun set(x: Int, y: Int, value: Int) {
            grid[x][y] = value
        }

        fun isBingo(validNumbers: List<Int>): Boolean {
            var isBingo = grid.any { row -> row.all { it in validNumbers } }
            isBingo = this[0, 0] in validNumbers && this[1, 0] in validNumbers && this[2, 0] in validNumbers && this[3, 0] in validNumbers && this[4, 0] in validNumbers ||
                    this[0, 1] in validNumbers && this[1, 1] in validNumbers && this[2, 1] in validNumbers && this[3, 1] in validNumbers && this[4, 1] in validNumbers ||
                    this[0, 2] in validNumbers && this[1, 2] in validNumbers && this[2, 2] in validNumbers && this[3, 2] in validNumbers && this[4, 2] in validNumbers ||
                    this[0, 3] in validNumbers && this[1, 3] in validNumbers && this[2, 3] in validNumbers && this[3, 3] in validNumbers && this[4, 3] in validNumbers ||
                    this[0, 4] in validNumbers && this[1, 4] in validNumbers && this[2, 4] in validNumbers && this[3, 4] in validNumbers && this[4, 4] in validNumbers ||
                    this[0, 0] in validNumbers && this[0, 1] in validNumbers && this[0, 2] in validNumbers && this[0, 3] in validNumbers && this[0, 4] in validNumbers ||
                    this[1, 0] in validNumbers && this[1, 1] in validNumbers && this[1, 2] in validNumbers && this[1, 3] in validNumbers && this[1, 4] in validNumbers ||
                    this[2, 0] in validNumbers && this[2, 1] in validNumbers && this[2, 2] in validNumbers && this[2, 3] in validNumbers && this[2, 4] in validNumbers ||
                    this[3, 0] in validNumbers && this[3, 1] in validNumbers && this[3, 2] in validNumbers && this[3, 3] in validNumbers && this[3, 4] in validNumbers ||
                    this[4, 0] in validNumbers && this[4, 1] in validNumbers && this[4, 2] in validNumbers && this[4, 3] in validNumbers && this[4, 4] in validNumbers
            return isBingo
        }

        override fun toString() = grid.joinToString("\n") { it.joinToString(" ") }
    }


}

