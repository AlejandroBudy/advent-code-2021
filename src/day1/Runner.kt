package day1

import readInputAsInt

fun main() {

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsInt("Day01_test", "day1")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputAsInt("Day01", "day1")
    println(part1(input))
    println(part2(input))
}