fun main() {
    val inputs = listOf(
        4 to 2,
        8 to 2,
        2147395599 to 1,
    )
    inputs.forEach {
        val result = No69().mySqrt(x = it.first)
        println("result: $result, expected: ${it.second}")
    }
}

class No69 {
    
//    fun mySqrt(x: Int): Int { // x=8
//        var start = 0 // 0, 2, 2
//        var end = x // 8, 4, 3
//        var result = 0 // 0, 4, 2, 3
//        while (start <= end) {
//            val mid = (start + end) / 2 // 4, 2, 3, 2
//            val sqrt = mid * mid // 16, 4, 9, 4
//            result = mid // 4, 2, 3, 2
//            if (sqrt < 0) {
//                end = mid - 1
//                continue
//            }
//            if (sqrt == x) {
//                break
//            } else if (sqrt > x) {
//                end = mid - 1 // 4, 3, 2
//            } else {
//                start = mid + 1 // 2
//            }
//        }
//        return result
//    }

    fun mySqrt(x: Int): Int {
        if (x < 2) return x
        var left = 1
        var right = x / 2
        var result = 0
        while (left <= right) {
            val mid = left + (right - left) / 2
            val square = mid.toLong() * mid.toLong()  // オーバーフロー対策
            if (square == x.toLong()) {
                return mid
            } else if (square < x.toLong()) {
                result = mid // 一番近い小さい平方数を保存
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return result
    }
}