import java.nio.file.Path

fun getInputFile(year: Int, day: Int, test: Boolean = false): Path {
    val tempDir = System.getProperty("java.io.tmpdir");
    return Path.of(tempDir, "aoc2021", "input", "challenge-${year}-${day}${if(test) "t-est" else ""}.txt")
}