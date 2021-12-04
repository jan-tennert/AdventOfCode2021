import aoc2021.Day1
import aoc2021.Day2
import aoc2021.Day3
import aoc2021.Day4

suspend fun main() {
    val session = System.getenv("AOC")
    val manager = ChallengeManager(session)
    println(manager.solveChallenge(Day4))
}

