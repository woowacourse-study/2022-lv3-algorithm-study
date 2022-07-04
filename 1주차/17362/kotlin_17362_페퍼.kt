fun main() {
    val n = readln().toInt()

    when (n % 8) {
        1 -> println(1)
        0, 2 -> println(2)
        3, 7 -> println(3)
        4, 6 -> println(4)
        5 -> println(5)
    }
}
