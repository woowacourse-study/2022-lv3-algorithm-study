import kotlin.math.max
import kotlin.math.min

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val cardA = input[0]
    val cardB = input[1]
    val cardC = input[2]

    val playerA = readln().split(" ").map { it.toInt() }.sorted()
    val playerB = readln().split(" ").map { it.toInt() }.sorted()
    val playerC = readln().split(" ").map { it.toInt() }.sorted()

    var answer = Int.MAX_VALUE


    var pointA = 0
    var pointB = 0
    var pointC = 0

    var result = 0

    while (true) {
        val max = max(Math.max(playerA.get(pointA), playerB.get(pointB)), playerC.get(pointC))
        val min =  min(Math.min(playerA.get(pointA), playerB.get(pointB)), playerC.get(pointC))
        if (max - min < result) {
            result = max - min
        }
        if (min == playerA.get(pointA) && pointA < cardA - 1) {
            pointA++
        } else if (min == playerB.get(pointB) && pointB < cardB - 1) {
            pointB
        } else if (min == playerC.get(pointC) && pointC < cardC - 1) {
            pointC++
        } else {
            break
        }
    }

    println(result)
}
