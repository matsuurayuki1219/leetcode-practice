fun main() {
    val inputs = listOf(
        ListNode(1).apply {
            next = ListNode(1).apply {
                next = ListNode(2)
            }
        },
        ListNode(1).apply {
            next = ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(3).apply {
                        next = ListNode(3)
                    }
                }
            }
        },
    )
    inputs.forEach {
        it.print()
        val result = No83().deleteDuplicates(head = it)
        result?.print()
    }
}

class No83 {
//    fun deleteDuplicates(head: ListNode?): ListNode? {
//        if (head == null) return null
//
//        val result = ListNode(head.`val`)
//        var current: ListNode? = result
//        var currentNum = head.`val`
//
//        var temp: ListNode? = head.next
//        while (temp != null) {
//            val `val` = temp.`val`
//            if (currentNum != `val`) {
//                currentNum = `val`
//                current?.next = ListNode(`val`)
//                current = current?.next
//            }
//            temp = temp.next
//        }
//
//        return result
//    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        var current = head

        while (current != null) {
            if (tail == dummy || tail.`val` != current.`val`) {
                tail.next = ListNode(current.`val`)
                tail = tail.next!!
            }
            current = current.next
        }

        return dummy.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun print() {
        print("result: ")
        var temp: ListNode? = this
        while (temp != null) {
            print("${temp.`val`}, ")
            temp = temp.next
        }
    }
}