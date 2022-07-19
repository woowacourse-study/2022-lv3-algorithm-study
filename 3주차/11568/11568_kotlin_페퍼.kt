import kotlin.math.max

fun main() {
    val N = readln().toInt()
    val cards = readln().split(" ").map { it.toInt() }
    val length: MutableList<Int> = MutableList(N) { 0 }

    for (i in 0 until  N) {
        length[i] = 1
        for (j in 0 until  i) {
            if (cards[j] < cards[i]) {
                length[i] = max(length[i], length[j] + 1)
            }
        }
    }

    println(length.maxOrNull() ?: 1)
}
