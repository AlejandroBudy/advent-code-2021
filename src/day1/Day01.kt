package day1

fun part1(input: List<Int>): Int = input.windowed(2).count { (a, b) -> a < b }
fun part2(input: List<Int>): Int = input.windowed(3).windowed(2).count { (a, b) -> a.sum() < b.sum() }

