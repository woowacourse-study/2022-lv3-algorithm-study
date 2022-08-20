# 2694 합이 같은 구간

import sys

readline = sys.stdin.readline

t = int(readline())
for _ in range(t):
    m = int(readline())
    array = []
    for _ in range((m - 1) // 10 + 1):
        array += list(map(int, readline().split()))

    start = 0
    for i in range(1, m + 1):
        start = sum(array[:i])
        now_sum = 0
        flag = True

        for j in range(i, m):
            now_sum += array[j]
            if now_sum > start:
                flag = False
                break
            elif now_sum == start:
                now_sum = 0

        if flag and now_sum == 0:
            break

    print(start)
