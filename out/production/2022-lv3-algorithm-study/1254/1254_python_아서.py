import sys

input = sys.stdin.readline

word = input().rstrip()


def is_palindrome(x):
    if x == x[::-1]:
        return True
    return False


cnt = 0
for i in range(len(word)):
    if is_palindrome(word[:i:-1]):
        cnt = i
        break

while True:
    if is_palindrome(word):
        print(len(word))
        break
    else:
        word += word[cnt]
        cnt -= 1
