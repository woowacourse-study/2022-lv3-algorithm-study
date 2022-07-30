import sys
input = sys.stdin.readline

def solution():
    text = input().rstrip()
    size = len(text)

    if (size == 1):
        return 1

    mid = size // 2
    for i in range(mid, size-1):

        left = text[:i]
        right = text[i:]

        index = left.rfind(right[::-1])
        if (index != -1 and index + len(right) * 2 == size):
            return size + index

        right = text[i+1:]
        index = left.rfind(right[::-1])
        if (index != -1 and index == i - len(right)):
            return size + index

    else:
        if (text[-1] != text[-2]):
            return size * 2 - 1
        return size * 2 - 2

print(solution())
