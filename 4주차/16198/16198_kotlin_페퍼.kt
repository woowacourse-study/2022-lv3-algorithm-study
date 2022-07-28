import kotlin.math.max

var maxEnergy = 0
var N = 0

fun main() {
    N = readln().toInt()
    val marbles = readln().split(" ").map { it.toInt() }.toMutableList()

    collectEnergy(0, marbles)
    println(maxEnergy)
}

fun collectEnergy(energy: Int, marbles: MutableList<Int>) {
    if (marbles.size == 2) {
        maxEnergy = max(maxEnergy, energy)
    } else {
        for (idx in 1 until marbles.size - 1) {
            val removedMarble = marbles.removeAt(idx)
            collectEnergy(energy + (marbles[idx - 1] * marbles[idx]), marbles)
            marbles.add(idx, removedMarble)
        }
    }
}
