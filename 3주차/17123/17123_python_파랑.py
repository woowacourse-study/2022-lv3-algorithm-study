# 17123 배열 놀이

import sys

readline = sys.stdin.readline

t = int(readline())


def init_sum_of_cols(arr):
    sum_of_cols = [0] * n
    for row in arr:
        for i in range(n):
            sum_of_cols[i] += row[i]
    return sum_of_cols


for _ in range(t):
    n, m = map(int, readline().split())
    arr = [list(map(int, readline().split())) for _ in range(n)]
    sum_of_rows = [sum(row) for row in arr]
    sum_of_cols = init_sum_of_cols(arr)

    for _ in range(m):
        r1, c1, r2, c2, v = map(int, readline().split())
        row = r2 - r1 + 1
        col = c2 - c1 + 1
        for r in range(r1 - 1, r2):
            sum_of_rows[r] += v * col
        for c in range(c1 - 1, c2):
            sum_of_cols[c] += v * row

    print(*sum_of_rows)
    print(*sum_of_cols)
