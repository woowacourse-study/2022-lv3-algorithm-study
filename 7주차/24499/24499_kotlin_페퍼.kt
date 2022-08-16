import kotlin.math.max

fun main() {
    var inputs = readln().split(" ")
    val N = inputs[0].toInt()
    val K = inputs[1].toInt()

    val flavor = IntArray(2 * N)
    inputs = readln().split(" ")

    for (i in 0 until N) {
        flavor[i] = inputs[i].toInt()
    }
    for (i in N until 2 * N) {
        flavor[i] = flavor[i - N]
    }

    var pieSum = 0
    for (i in 0 until K) {
        pieSum += flavor[i]
    }

    var result = pieSum
    for (i in 0 until N) {
        result -= flavor[i]
        result += flavor[i + K]
        pieSum = max(pieSum, result)
    }
    println(pieSum)
}
