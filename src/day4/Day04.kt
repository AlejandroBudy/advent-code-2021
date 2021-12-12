package day4

fun part1(input: List<String>) {
    val pair = cleanData(input)
    val numbers = pair.first
    var boards = pair.second

    numbers.forEach { number ->
        boards.forEach { board ->
            board.mark(number)
            if (board.isCompleted()) {
                val sumOfUnmarkedFields = board.unmarked().sum()
                println(sumOfUnmarkedFields * number)
                boards = boards - board
            }
        }
    }
}

data class Field(val value: Int, val marked: Boolean = false)

data class Board(val fields: List<MutableList<Field>>) {
    private val rowIndex = fields[0].indices

    private val columnIndex = fields.indices
    fun mark(number: Int) {
        fields.forEach { line ->
            line.replaceAll {
                if (it.value == number) it.copy(marked = true) else it
            }
        }
    }

    fun isCompleted() = isRowCompleted() || isColumnCompleted()

    private fun isRowCompleted() = fields.any { row -> row.all { it.marked } }
    private fun isColumnCompleted(): Boolean {
        rowIndex.forEach { column ->
            var columnOk = true
            for (row in columnIndex) {
                if (!fields[row][column].marked) {
                    columnOk = false
                    continue
                }
            }
            if (columnOk) return true
        }
        return false
    }

    fun unmarked() = fields.flatten().filter { !it.marked }.map { it.value }

}

private fun cleanData(input: List<String>): Pair<List<Int>, List<Board>> {
    val values = input.drop(1).chunked(6).map { lines -> lines.filter { it.isNotBlank() } }
    val numbers = input.first().split(',').map { it.toInt() }
    val boards =
        values.map { singleBoard: List<String> ->
            singleBoard.map { line ->
                line.trim()
                    .split(Regex("\\W+"))
                    .map {
                        it.toInt()
                    }
            }
        }.toBoardList()
    return Pair(numbers, boards)
}

fun List<List<List<Int>>>.toBoardList() = this.map { it.toBoard() }
fun List<List<Int>>.toBoard() = Board(this.map { row -> row.map { Field(it, false) }.toMutableList() })