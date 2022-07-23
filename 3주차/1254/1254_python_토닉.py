import sys

input = sys.stdin.readline

li = list(input().rstrip())
length = len(li)
minus_length = 1

def isPalindrom(li):
    if len(li) % 2:
        return "".join(li[:len(li) // 2]) == "".join(li[len(li) // 2 + 1:][::-1])
    return "".join(li[:len(li) // 2]) == "".join(li[len(li) // 2:][::-1])

if length == 0 or length == 1:
    print(length)
else:
    now_char = li[length-1]
    for i in range(length-1):
        if now_char == li[i]:
            temp = li[i:length]
            if isPalindrom(temp):
                minus_length = len(temp)
                break
    print(length * 2 - minus_length)
