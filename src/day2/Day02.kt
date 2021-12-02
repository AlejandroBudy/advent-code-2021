package day2

fun part1(input: List<String>): Int {
    var forward = 0
    var depth = 0
    input.forEach {
        val key = it.split(" ")[0]
        val value = it.split(" ")[1].toInt()
        when (key) {
            "forward" -> forward += value
            "down" -> depth += value
            "up" -> depth -= value
        }
    }
    return forward * depth
}

fun part2(input: List<String>): Int {
    var aim = 0
    var depth = 0
    var horizontal = 0
    val downer: (Int) -> Unit = { aim += it }
    val upper: (Int) -> Unit = { aim -= it }
    val forwarder: (Int) -> Unit = {
        depth += (it * aim)
        horizontal += it
    }

    input.forEach {
        val key = it.split(" ")[0]
        val value = it.split(" ")[1].toInt()
        when (key) {
            "forward" -> forwarder(value)
            "down" -> downer(value)
            "up" -> upper(value)
        }
    }
    return horizontal * depth
}