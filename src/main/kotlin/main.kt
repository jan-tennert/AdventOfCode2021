import aoc2021.Day1
import aoc2021.Day2

suspend fun main() {
    val session = System.getenv("AOC")
    val manager = ChallengeManager(session)
    println(manager.solveChallenge(Day2))
}