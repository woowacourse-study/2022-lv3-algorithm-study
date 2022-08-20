import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.regex.Pattern

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val array = arrayListOf<String>()
    for (i in 0 until n) {
        val input = br.readLine()
        array.add(input)
    }
    println("SLURPYS OUTPUT")
    for (i in 0 until n) {
        val input = array[i]
        var res = false
        for (j in 2..input.length - 3) {
            val slumpStr = input.substring(0, j)
            val slimpStr = input.substring(j, input.length)
            if (isSlimp(slumpStr) && isSlump(slimpStr)) {
                res = true
                break
            }
        }
        if (res) {
            println("YES")
        } else {
            println("NO")
        }
    }
    println("END OF OUTPUT")
}

fun isSlump(str: String): Boolean {
    val reg = "^((D|E)(F)+)+(G)$"
    return Pattern.matches(reg, str)
}

fun isSlimp(str: String): Boolean {
    if (str.length > 3) {
        if (Pattern.matches("(AB)\\w+(C)$", str)) {
            val input = str.substring(2, str.length - 1)
            return isSlimp(input)
        } else if (Pattern.matches("(A)\\w+(C)$", str)) {
            val input = str.substring(1, str.length - 1)
            return isSlump(input)
        }

    } else {
        if (str == "AH") return true
    }
    return false
}