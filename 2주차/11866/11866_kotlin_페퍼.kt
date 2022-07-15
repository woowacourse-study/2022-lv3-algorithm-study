fun main() {
    val inputs = readln().split(" ")
    val n = inputs[0].toInt()
    val k = inputs[1].toInt()

    val deque = initDeque(n)
    val progression = ArrayList<Int>()
    var pointer = 1

    while (deque.isNotEmpty()) {
        val number = deque.removeFirst()
        if (pointer != k) {
            deque.add(number)
            pointer++
        } else {
            progression.add(number)
            pointer = 1
        }
    }

    println(progression.joinToString(prefix = "<", postfix = ">"))
}

private fun initDeque(n: Int): ArrayDeque<Int> {
    val deque = ArrayDeque<Int>()
    for (number in 1..n) {
        deque.add(number)
    }
    return deque
}
