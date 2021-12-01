import io.ktor.client.HttpClient
import io.ktor.client.request.cookie
import io.ktor.client.request.get
import java.nio.file.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.createFile
import kotlin.io.path.exists
import kotlin.io.path.readLines
import kotlin.io.path.writeLines

class ChallengeManager(private val session: String) {

    private val baseURL = "https://adventofcode.com/%s/day/%s/input"
    private val http = HttpClient()
    private val tempDir = System.getProperty("java.io.tmpdir");

    private suspend fun getInputFor(year: Int, day: Int) : List<String> {
        val input = http.get<String>(baseURL.format(year, day)) {
            cookie("session", session)
        }
        return input.split(System.lineSeparator())
    }

    suspend fun <T> solveChallenge(challenge: Challenge<T>): Pair<T, T> {
        val inputCache = Path.of(tempDir, "aoc2021", "input", "challenge-${challenge.year}-${challenge.day}.txt")
        val input = if(inputCache.exists()) inputCache.readLines() else getInputFor(challenge.year, challenge.day).also {
            inputCache.parent.createDirectories()
            inputCache.createFile()
            inputCache.writeLines(it)
        }
        return challenge.solvePartOne(input) to challenge.solvePartTwo(input)
    }

}