fun main() {
    val shuffleCount = readLine()!!.toInt()

    var jokerPoint = 1

    for (i: Int in 0 until shuffleCount) {
        val shuffleCommands = readLine()!!.split(" ")
        var totalSum = 0
        if (jokerPoint < 14) {
            var leftSum = 0
            for (j: Int in shuffleCommands.indices) {
                if (j % 2 != 0) {
                    if (leftSum + shuffleCommands[j].toInt() >= jokerPoint) {
                        jokerPoint = totalSum + jokerPoint - leftSum
                        break
                    }
                    leftSum += shuffleCommands[j].toInt()
                }
                totalSum += shuffleCommands[j].toInt()
            }
        } else {
            jokerPoint -= 13
            var rightSum = 0
            for (j: Int in shuffleCommands.indices) {
                if (j % 2 == 0) {
                    if (rightSum + shuffleCommands[j].toInt() >= jokerPoint) {
                        jokerPoint = totalSum + jokerPoint - rightSum
                        break
                    }
                    rightSum += shuffleCommands[j].toInt()
                }
                totalSum += shuffleCommands[j].toInt()
            }
        }
    }

    println(jokerPoint)
}
