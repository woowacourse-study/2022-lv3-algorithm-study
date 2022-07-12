fun main() {
    var case = 1
    while (true) {
        val inputs = readln().split(" ")
        val L = inputs[0].toInt()
        val P = inputs[1].toInt()
        val V = inputs[2].toInt()

        if (L == 0)
            break

        val remainder = V % P
        val quotient = V / P

        if (remainder >= L) {
            println("Case $case: ${(quotient + 1) * L}")
        } else {
            println("Case $case: ${quotient * L + remainder}")
        }
        case++
    }
}
