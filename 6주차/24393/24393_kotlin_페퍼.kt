fun main() {
    var N = readln().toInt()
    val deque = ArrayDeque<Int>()

    deque.add(1)
    for (i in 0..25) {
        deque.add(0)
    }

    while (N-- > 0) {
        val left = ArrayDeque<Int>()
        val right = ArrayDeque<Int>()
        for (i in 0..12) {
            left.add(deque.removeFirst())
        }
        for (i in 0..13) {
            right.add(deque.removeFirst())
        }

        var turn = true
        val input = readln().split(" ").map { it.toInt() }
        input.forEach {
            var count = it
            if (turn) {
                while (count-- > 0) {
                    deque.add(right.removeFirst())
                }
            } else {
                while (count-- > 0) {
                    deque.add(left.removeFirst())
                }
            }
            turn = !turn
        }
    }

    var result = 1
    while (deque.removeFirst() == 0) {
        result++
    }

    println(result)
}
