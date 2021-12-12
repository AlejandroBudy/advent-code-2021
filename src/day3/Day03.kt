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

fun part2(input: List<String>): Int {
    var oxygen: List<String> = input
    var co2: List<String> = input
    input[0].indices.forEach { idx ->
        var zero = oxygen.count { it[idx] == '0' }
        var one = oxygen.size - zero
        if (oxygen.size > 1) {
            oxygen = if (one >= zero) {
                oxygen.filter { it[idx] == '1' }
            } else {
                oxygen.filter { it[idx] == '0' }
            }
        }
        zero = co2.count { it[idx] == '0' }
        one = co2.size - zero
        if (co2.size > 1) {
            co2 = if (zero <= one) {
                co2.filter { it[idx] == '0' }
            } else {
                co2.filter { it[idx] == '1' }
            }
        }
    }
    return oxygen.first().asDecimal() * co2.first().asDecimal()
}

fun String.asDecimal(): Int = toInt(2)