import com.sun.source.tree.Tree

fun main () {
    val p = No100.TreeNode(1).apply {
        left = No100.TreeNode(2)
    }
    val q = No100.TreeNode(1).apply {
        left = No100.TreeNode(2)
    }
    val result = No100().isSameTree(p = p, q = q)
    println("result: $result")
}

class No100 {
//    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
//        if (p == null && q == null) return true
//        if (p?.`val` != q?.`val`) return false
//        val isLeftSame = isSameTree(p = p?.left, q = q?.left)
//        if (isLeftSame.not()) return false
//        val isRightSame = isSameTree(p = p?.right, q = q?.right)
//        if (isRightSame.not()) return false
//        return true
//    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        // 両方 null → 同じ
        if (p == null && q == null) return true
        // 一方だけ null → 違う
        if (p == null || q == null) return false
        // 値が異なる → 違う
        if (p.`val` != q.`val`) return false

        // 左右のサブツリーが同じかを再帰的に比較
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}