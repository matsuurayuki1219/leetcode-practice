
fun main () {
    val inputs = listOf(
        intArrayOf(2,7,11,15) to 9,
        intArrayOf(3,2,4) to 6,
        intArrayOf(3,3) to 6,
    )
    inputs.forEach {
        val result = No1().twoSum(nums = it.first, target = it.second)
        println("result: ${result.toList()}")
    }
}

class No1 {
//    fun twoSum(nums: IntArray, target: Int): IntArray {
//        for (i in 0 until nums.size - 1) {
//            for (j in i + 1 until nums.size) {
//                if (nums[i] + nums[j] == target) return intArrayOf(i, j)
//            }
//        }
//        return intArrayOf()
//    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for ((index, curr) in nums.withIndex()) {
            val rest = target - curr
            if (map.containsKey(rest)) {
                return intArrayOf(map[rest]!!, index)
            }
            map[curr] = index
        }
        throw IllegalStateException("No two sum solution found")
    }
}
