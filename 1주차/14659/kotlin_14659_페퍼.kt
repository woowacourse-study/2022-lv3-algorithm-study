import kotlin.math.max

fun main(args: Array<String>) {
    val n = readln().toInt()
    val archers = readln().split(" ").map { it.toInt() }
    var maxCount = 0

    var idx = 1
    var archer = archers[0]
    var cnt = 0
    while (idx < n) {
        if (archer > archers[idx]) {
            cnt++
        } else {
            maxCount = max(cnt, maxCount)
            cnt = 0
            archer = archers[idx]
        }
        idx++
    }
    println(max(maxCount, cnt))
}
