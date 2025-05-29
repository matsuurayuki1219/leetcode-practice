fun main() {
    val inputs = listOf(
        Triple("11", "1", "100"),
        Triple("1010", "1011", "10101"),
    )
    inputs.forEach {
        val result = Solution_20250528().addBinary(a = it.first, b = it.second)
        println("result: $result, expected: ${it.third}")
    }
}

class Solution_20250528 {
    fun addBinary(a: String, b: String): String {

        // chatgpt
        var i = a.length - 1
        var j = b.length - 1
        var carry = 0
        val result = StringBuilder()
        while (i >= 0 || j >= 0 || carry != 0) {
            var sum = carry
            if (i >= 0) {
                sum += a[i] - '0'
                i--
            }
            if (j >= 0) {
                sum += b[j] - '0'
                j--
            }
            result.append(sum % 2)
            carry = sum / 2
        }
        return result.reverse().toString()
    }
}