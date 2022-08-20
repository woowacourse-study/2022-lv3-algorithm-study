import kotlin.math.max
import kotlin.math.min

fun main() {
    var input = readln().split(" ").map { it.toInt() }

    val n = input[0]
    val m = input[1]
    val r = input[2]

    val items = IntArray(n + 1)
    val edges = Array(n + 1) { IntArray(n + 1) }
    val maxLength = 16
    input = readln().split(" ").map { it.toInt() }
    for (i in 1..n) {
        items[i] = input[i - 1]
    }

    for (i in 1..n) {
        for (j in 1..n) {
            edges[i][j] = maxLength
        }
    }

    for (i in 0 until r) {
        input = readln().split(" ").map { it.toInt() }
        val a = input[0]
        val b = input[1]
        val l = input[2]
        edges[a][b] = l
        edges[b][a] = l
    }

    for (i in 1..n) {
        for (j in 1..n) {
            for (k in 1..n) {
                if (i == j || j == k || i == k) continue
                edges[j][k] = min(edges[j][i] + edges[i][k], edges[j][k])
            }
        }
    }

    var maxNum = 0
    for (i in 1..n) {
        var tmp = items[i]
        for (j in 1..n) {
            if (edges[i][j] <= m) {
                tmp += items[j]
            }
        }
        maxNum = max(tmp, maxNum)
    }

    println(maxNum)
}
