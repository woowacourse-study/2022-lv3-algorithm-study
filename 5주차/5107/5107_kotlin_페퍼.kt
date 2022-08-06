val finished = HashMap<String, Boolean>()
val visited = HashMap<String, Boolean>()
val manittos = HashMap<String, String>()
var cycle = 0

fun main() {

    var T = 1
    while (true) {
        val N = readln().toInt()
        if (N == 0)
            break

        initManittos(N)
        manittos.forEach {
            if (visited[it.key] == false) {
                dfs(it.key)
            }
        }
        println("$T $cycle")
        T++
    }
}

private fun dfs(person: String) {
    visited[person] = true
    val nxt = manittos[person]
    if (visited[nxt] == false)
        nxt?.let { dfs(it) }
    else if (finished[nxt] == false)
        cycle++
    finished[person] = true
}

private fun initManittos(N: Int) {
    finished.clear()
    visited.clear()
    manittos.clear()
    cycle = 0

    var n = N
    while (n > 0) {
        val manitto = readln().split(" ")
        manittos[manitto[0]] = manitto[1]
        finished[manitto[0]] = false
        finished[manitto[1]] = false
        visited[manitto[0]] = false
        visited[manitto[1]] = false
        n--
    }
}
