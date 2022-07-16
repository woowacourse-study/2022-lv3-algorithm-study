# 1254 팰린드롬 만들기

import sys


def isPalindrom(s, palindrom):
    for i in range(len(palindrom) // 2):
        if s[i] != palindrom[len(palindrom) - i - 1]:
            return False
    return True


s = sys.stdin.readline().strip()
palindrom = s
for length in range(0, len(s)):
    if isPalindrom(s, palindrom):
        break
    palindrom = s + s[length::-1]
print(len(palindrom))