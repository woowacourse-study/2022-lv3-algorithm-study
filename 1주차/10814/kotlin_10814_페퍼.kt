fun main() {
    val n = readln().toInt()

    val members = ArrayList<Member>()
    for (i in 1..n) {
        val member = readln().split(" ")
        members.add(Member(member[0].toInt(), member[1]))
    }
    members.sort()

    members.forEach {
        println("${it.age} ${it.name}")
    }
}

class Member(val age: Int, val name: String) : Comparable<Member> {
    override fun compareTo(other: Member): Int = age - other.age
}
