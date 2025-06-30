import com.sun.source.tree.Tree

fun main() {
    val inputs = listOf(
        TreeNode(1).apply {
            left = null
            right = TreeNode(2).apply {
                left = TreeNode(3)
                right = null
            }
        },
    )
    inputs.forEach {
        No94().inorderTraversal(root = it)
    }
}

class No94 {
//    fun inorderTraversal(root: TreeNode?): List<Int> {
//        if (root == null) return emptyList()
//        val left = root.left
//        val right = root.right
//        val result = mutableListOf<Int>()
//        if (left != null) result += inorderTraversal(root = left)
//        result += root.`val`
//        if (right != null) result += inorderTraversal(root = right)
//        return result
//    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        fun traverse(node: TreeNode?) {
            if (node == null) return
            traverse(node.left)
            result.add(node.`val`)
            traverse(node.right)
        }
        traverse(root)
        return result
    }


}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}