package leetcode.solution

/**
 * - https://leetcode.com/problems/rotate-image/description/
 * - 전치 + 반전 방법
 */
class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        for (row in 0 until matrix.size) {
            for (column in row until matrix.size) {
                val temp = matrix[row][column]
                matrix[row][column] = matrix[column][row]
                matrix[column][row] = temp
            }
        }
        for (row in 0 until matrix.size) {
            for (column in 0 until matrix.size/2) {
                val temp = matrix[row][column]
                matrix[row][column] = matrix[row][matrix.size-column-1]
                matrix[row][matrix.size-column-1] = temp
            }
        }
    }

    fun printResult(matrix: Array<IntArray>) {
        for (row in 0 until matrix.size) {
            for (column in 0 until matrix.size) {
                print(String.format("%d ", matrix[row][column]))
            }
            println()
        }
    }
}

fun main() {
    val rotateImage = RotateImage()

    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )

    // 90도 회전
    rotateImage.rotate(matrix)
    rotateImage.printResult(matrix)
}