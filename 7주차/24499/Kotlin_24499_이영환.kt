import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val pies = arrayListOf<Int>()
    st = StringTokenizer(readLine())
    for (i:Int in 1 .. n) {
        pies.add(st.nextToken().toInt())
    }
    var now = pies.subList(0, k).sum()
    var max = now
    var firstOfPiePieces = 0
    for (i:Int in k until n + k) {
        val temp = now - pies[firstOfPiePieces] + pies[i % n]
        if (temp > max) {
            max = temp
        }
        now = temp
        firstOfPiePieces++
    }

    println(max)
}
