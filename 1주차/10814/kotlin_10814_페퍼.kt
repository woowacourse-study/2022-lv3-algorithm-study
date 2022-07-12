fun main() {
    val n = readln().toInt()

    val members = ArrayList<Pair<Int, String>>()
    for (i in 1..n) {
        val member = readln().split(" ")
        members.add(member[0].toInt() to member[1])
    }

    members.sortBy { it.first }

    members.forEach {
        println("${it.first} ${it.second}")
    }
}
