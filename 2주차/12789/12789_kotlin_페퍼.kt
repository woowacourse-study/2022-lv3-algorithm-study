import java.util.*

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toMutableList()
    val stack = Stack<Int>()

    var target = 1
    while (numbers.isNotEmpty()) {
        if (stack.isNotEmpty() && stack.peek() == target) {
            target++
            stack.pop()
            continue
        }
        val number = numbers.removeFirst()
        if (number == target) {
            target++
        } else {
            stack.push(number)
        }
    }

    while (stack.isNotEmpty() && stack.peek() == target) {
        stack.pop()
        target++
    }

    if (target >= n) {
        println("Nice")
    } else {
        println("Sad")
    }
}
