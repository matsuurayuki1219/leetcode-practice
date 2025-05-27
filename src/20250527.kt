// https://leetcode.com/problems/plus-one/description/
fun main() {
    val inputs = listOf(
        intArrayOf(1,2,3) to intArrayOf(1,2,4),
        intArrayOf(4,3,2,1) to intArrayOf(4,3,2,2),
        intArrayOf(9) to intArrayOf(1,0),
        intArrayOf(9,9) to intArrayOf(1,0,0),
    )
    inputs.forEach { input ->
        val result = Solution_20250527().plusOne(digits = input.first)
        println("result: ${result.map { it }}, expected: ${input.second.map { it }}")
    }
}

class Solution_20250527 {
    fun plusOne(digits: IntArray): IntArray {

        // my answer
        var result = digits
        var isUp = false
        for (i in digits.size - 1 downTo 0) {
            if (i == digits.size - 1) result[i] += 1
            if (isUp) result[i] += 1
            if (result[i] == 10) {
                isUp = true
                result[i] = 0
            } else {
                isUp = false
            }
            if (isUp.not()) break
        }
        if (result[0] == 0) result = intArrayOf(1) + result
        return result

        /*
        // chatgpt
        val result = digits.copyOf() // 元の配列を変更しない
        for (i in result.size - 1 downTo 0) {
            if (result[i] < 9) {
                result[i]++
                return result // 桁上がり不要、ここで終了
            }
            result[i] = 0 // 9 → 0 にしてループ継続（繰り上げ）
        }
        // すべて 9 だった場合 → [1, 0, 0, ..., 0]
        return IntArray(result.size + 1).apply { this[0] = 1 }
        */
    }
}