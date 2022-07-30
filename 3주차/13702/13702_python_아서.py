import sys

input = sys.stdin.readline

n, k = map(int, input().split())
jars = list(int(input()) for _ in range(n))


def count_glass(amount, total):
    cnt = 0
    for x in total:
        cnt += x // amount
    return cnt


lt, rt = 1, max(jars)
res = 0

while lt <= rt:
    mid = (lt + rt) // 2
    glass = count_glass(mid, jars)

    if glass >= k:
        res = mid
        lt = mid + 1
    else:
        rt = mid - 1

print(res)
