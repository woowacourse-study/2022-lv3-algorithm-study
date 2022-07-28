fun main() {
    val inputs = readln().split(" ")
    val N = inputs[0].toInt()
    val M = inputs[1].toInt()
    val screen = initScreen(N, M)
    val T = readln().toInt()

    reconfigureScreen(N, M, screen, T)

    val visited = Array(N) { BooleanArray(M) { false } }
    var count = 0
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (screen[i][j] == 255 && !visited[i][j]) {
                count++
                bfs(i, j, visited, N, M, screen)
            }
        }
    }

    println(count)
}

private fun bfs(
    i: Int,
    j: Int,
    visited: Array<BooleanArray>,
    N: Int,
    M: Int,
    screen: Array<IntArray>
) {
    val dir = arrayOf(arrayOf(0,1),arrayOf(1,0),arrayOf(0,-1),arrayOf(-1,0))
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(Pair(i, j))
    visited[i][j] = true

    while (queue.isNotEmpty()) {
        val pair = queue.removeFirst()
        for (d in 0 until 4) {
            val nx = pair.first + dir[d][0]
            val ny = pair.second + dir[d][1]
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue
            }
            if (screen[nx][ny] == 255 && !visited[nx][ny]) {
                queue.add(Pair(nx, ny))
                visited[nx][ny] = true
            }
        }
    }
}

private fun reconfigureScreen(N: Int, M: Int, screen: Array<IntArray>, T: Int) {
    for (i in 0 until N) {
        for (j in 0 until M) {
            screen[i][j] = if (screen[i][j] >= T) {
                255
            } else {
                0
            }
        }
    }
}

private fun initScreen(N: Int, M: Int): Array<IntArray> {
    val screen = Array(N) { IntArray(M) }

    for (i in 0 until N) {
        val rowInput = readln().split(" ").map { it.toInt() }
        var idx = 0
        var colorSum = 0
        var j = 0
        while (idx < rowInput.size) {
            colorSum += rowInput[idx++]
            if (idx % 3 == 0) {
                screen[i][j++] = (colorSum / 3)
                colorSum = 0
            }
        }
    }
    return screen
}
