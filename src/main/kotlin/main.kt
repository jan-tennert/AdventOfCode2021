import aoc2021.Day1
import aoc2021.Day2
import aoc2021.Day3

suspend fun main() {
    val session = System.getenv("AOC")
    val manager = ChallengeManager(session)
    println(manager.solveChallenge(Day3))
}

