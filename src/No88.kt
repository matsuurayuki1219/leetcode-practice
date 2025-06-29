
fun main () {
    val inputs = listOf(
        // Input(intArrayOf(1,2,3,0,0,0,), 3, intArrayOf(2,5,6,), 3,),
        Input(intArrayOf(-1,0,0,3,3,3,0,0,0,), 6, intArrayOf(1,2,2,), 3,),
    )
    inputs.forEach {
        No88().merge(nums1 = it.num1, m = it.m, nums2 = it.num2, n = it.n)
        print("result: num1 = ")
        it.num1.forEach { it ->
            print("$it,")
        }
        
    }
}

class No88 {
//    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
//        for (i in 0 until n) {
//            for (j in 0 until i + m + 1) {
//                if (nums1[j] > nums2[i]) {
//                    val temp = nums1[j]
//                    nums1[j] = nums2[i]
//                    nums2[i] = temp
//                } else if (j == i + m) {
//                    nums1[j] = nums2[i]
//                }
//            }
//        }
//    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var p1 = m - 1
        var p2 = n - 1
        var p = m + n - 1

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1]
                p1 -= 1
            } else {
                nums1[p] = nums2[p2]
                p2 -= 1
            }
            p -= 1
        }

        while (p2 >= 0) {
            nums1[p] = nums2[p2]
            p -= 1
            p2 -= 1
        }
    }

}

data class Input(
    val num1: IntArray,
    val m: Int,
    val num2: IntArray,
    val n: Int,
)