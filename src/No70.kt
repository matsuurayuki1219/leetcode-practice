fun main() {
    val inputs = listOf(
        // 2 to 2,
        // 3 to 3,
        // 5 to 8,
        // 6 to 13,
        35 to 14930352,
    )
    inputs.forEach {
        val result = No70().climbStairs(n = it.first)
        println("result: $result, expected: ${it.second}")
    }
}

class No70 {
    //    fun climbStairs(n: Int): Int {
//        var result = 0
//        for (i in 0..n / 2) {
//            val left = n - i
//            val right = i
//            if (right == 0 || left == right) {
//                result += 1
//            } else {
//                var child = 1
//                var mother = 1
//                for (j in 1..right) {
//                    mother *= j
//                    child *= left - j + 1
//                }
//                result += child / mother
//            }
//        }
//        return result
//    }

    fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        var a = 1
        var b = 2
        for (i in 3..n) {
            val temp = a + b
            a = b
            b = temp
        }
        return b
    }
}