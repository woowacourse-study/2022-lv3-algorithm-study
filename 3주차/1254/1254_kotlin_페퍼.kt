import kotlin.math.min

fun main() {
    val originStr = readln()
    val originStrLength = originStr.length

    if (originStrLength == 1) {
        println(1)
        return
    }

    var answer = (originStrLength * 2) - 1

    for (i in (originStrLength / 2) until originStrLength) {
        answer = reflectByNumber(originStr, i, originStrLength, answer)
        if (answer == originStrLength) {
            println(answer)
            return
        }

        val before = originStr.substring(0 until i).reversed()
        val after = originStr.substring(i until originStrLength)
        if (before.length < after.length) {
            continue
        }

        answer = reflect(after, before, answer, originStrLength)
    }

    println(answer)
}

private fun reflectByNumber(
    originStr: String,
    i: Int,
    originStrLength: Int,
    answer: Int
): Int {
    var answer1 = answer
    val before = originStr.substring(0 until i).reversed()
    val after = originStr.substring(i + 1 until originStrLength)

    answer1 = reflect(after, before, answer1, originStrLength)
    return answer1
}

private fun reflect(
    after: String,
    before: String,
    answer: Int,
    originStrLength: Int
): Int {
    var answer1 = answer
    var idx = 0
    var count = 0
    while (idx < after.length && before[idx] == after[idx]) {
        count++
        idx++
    }

    if (idx == after.length) {
        answer1 = min(answer1, originStrLength + (before.length - after.length))
    }
    return answer1
}
