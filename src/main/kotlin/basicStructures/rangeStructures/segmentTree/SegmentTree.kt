package basicStructures.rangeStructures.segmentTree

class SegmentTree<T>(
    private val data: List<T>,
    private val default: T,
    private val combine: (T, T) -> T
) {
    private val n = data.size
    private val tree = MutableList(4 * n) { default }

    init {
        build(0, 0, n - 1)
    }

    private fun build(node: Int, left: Int, right: Int) {
        if (left == right) {
            tree[node] = data[left]
        } else {
            val mid = (left + right) / 2
            build(2 * node + 1, left, mid)
            build(2 * node + 2, mid + 1, right)
            tree[node] = combine(tree[2 * node + 1], tree[2 * node + 2])
        }
    }

    fun query(queryLeft: Int, queryRight: Int): T {
        require(queryLeft in 0..queryRight && queryRight < n)
        return queryRec(0, 0, n - 1, queryLeft, queryRight)
    }

    private fun queryRec(node: Int, left: Int, right: Int, ql: Int, qr: Int): T {
        if (qr < left || ql > right) return default
        if (ql <= left && right <= qr) return tree[node]

        val mid = (left + right) / 2
        val leftVal = queryRec(2 * node + 1, left, mid, ql, qr)
        val rightVal = queryRec(2 * node + 2, mid + 1, right, ql, qr)
        return combine(leftVal, rightVal)
    }

    fun update(index: Int, newValue: T) {
        require(index in 0 until n)
        updateRec(0, 0, n - 1, index, newValue)
    }

    private fun updateRec(node: Int, left: Int, right: Int, index: Int, newValue: T) {
        if (left == right) {
            tree[node] = newValue
        } else {
            val mid = (left + right) / 2
            if (index <= mid) updateRec(2 * node + 1, left, mid, index, newValue)
            else updateRec(2 * node + 2, mid + 1, right, index, newValue)
            tree[node] = combine(tree[2 * node + 1], tree[2 * node + 2])
        }
    }

    override fun toString(): String = tree.take(2 * n).joinToString(", ", prefix = "[", postfix = "]")
}
