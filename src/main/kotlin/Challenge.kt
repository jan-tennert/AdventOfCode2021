abstract class Challenge <T>(val year: Int, val day: Int) {

    abstract fun solvePartOne(input: List<String>) : T

    abstract fun solvePartTwo(input: List<String>) : T

}