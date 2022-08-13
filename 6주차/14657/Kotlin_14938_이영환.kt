import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

const val MAX_LEN = 16

fun main() {
    var st = StringTokenizer(readLine())
    val regionCount = st.nextToken().toInt()
    val moveRange = st.nextToken().toInt()
    val roadCount = st.nextToken().toInt()

    val items = Array(regionCount + 1) { 0 }
    val edges = Array(regionCount + 1) { Array(regionCount + 1) { MAX_LEN } }

    st = StringTokenizer(readLine())
    for (i: Int in 1 .. regionCount) {
        items[i] = st.nextToken().toInt()
    }

    for (i: Int in 0 until roadCount) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val l = st.nextToken().toInt()

        edges[a][b] = l
        edges[b][a] = l
    }

    for (i: Int in 1 .. regionCount) { // 경유지
        for (j: Int in 1 .. regionCount) { // 출발지
            for (k: Int in 1 .. regionCount) { // 도착지
                if (i == j || j == k || i == k) {
                    continue
                }
                // 기존 j 부터 k 까지 길보다 i를 경유해서 가는 길이 더 짧으면 갱신.
                edges[j][k] = min(edges[j][i] + edges[i][k], edges[j][k])
            }
        }
    }

    var maxNum = 0
    for (i: Int in 1 .. regionCount) {
        var temp = items[i]
        for (j: Int in 1 .. regionCount) {
            // i에서 j까지 길의 길이가 수색범위 이내일 때
            if (edges[i][j] <= moveRange) {
                temp += items[j]
            }
        }
        maxNum = max(temp, maxNum)
    }

    println(maxNum)
}
