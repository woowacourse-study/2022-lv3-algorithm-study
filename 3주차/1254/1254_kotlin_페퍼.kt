fun main() {
    val originStr = readln()
    val size = originStr.length

    for (i in 0..size) {
        val substring = originStr.substring(i, size)
        if (substring.isPalindrome()) {
            println(size + i)
            return
        }
    }
}

private fun String.isPalindrome(): Boolean {
    if (this == this.reversed())
        return true
    return false
}

