fun main() {
    var inputs = readIntInput()
    val N = inputs[0]
    val M = inputs[1]
    inputs = readIntInput()
    val S = inputs[0]
    val E = inputs[1]

    val teleportStations = initTeleports(N, M)

    val dir = arrayOf(-1, 1)
    val queue = ArrayDeque<Int>()
    val visited = IntArray(N + 1) { -1 }

    queue.add(S)
    visited[S] = 0

    while (queue.isNotEmpty()) {
        val x = queue.removeFirst()
        if (x == E) {
            break
        }
        for (idx in 0 .. 1) {
            canGo(x + dir[idx], N, visited, queue, x) // x + 1, x - 1 방향
        }
        teleportStations[x].forEach {
            canGo(it, N, visited, queue, x) // 텔레포트
        }
    }

    println(visited[E])
}

private fun initTeleports(N: Int, M: Int): ArrayList<ArrayList<Int>> {
    val teleportStations = ArrayList<ArrayList<Int>>(N + 1)

    for (i in 0 .. N) {
        teleportStations.add(ArrayList())
    }

    for (i in 1..M) {
        val stations = readIntInput()
        teleportStations[stations[0]].add(stations[1])
        teleportStations[stations[1]].add(stations[0])
    }
    return teleportStations
}

private fun canGo(
    nx: Int,
    N: Int,
    visited: IntArray,
    queue: ArrayDeque<Int>,
    x: Int
) {
    if (nx in 1..N && visited[nx] == -1) {
        queue.add(nx)
        visited[nx] = visited[x] + 1
    }
}

private fun readIntInput() = readln().split(" ").map { it.toInt() }
