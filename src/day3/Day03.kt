package day3

fun part1(input: List<String>): Int {
    val gamma = StringBuilder()
    val epsilon = StringBuilder()
    input[0].indices.forEach { index ->
        val zero = input.count { it[index] == '0' }
        val one = input.size - zero
        gamma.append(if (zero > one) "0" else "1")
        epsilon.append(if (zero > one) "1" else "0")
    }
    return gamma.toString().asDecimal() * epsilon.toString().asDecimal()
}

fun part2(input: List<Int>): Int = TODO()

fun String.asDecimal(): Int = toInt(2)