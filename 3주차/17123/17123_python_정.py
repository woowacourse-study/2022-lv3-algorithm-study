import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    row_sums = [0 for _ in range(N)]
    col_sums = [0 for _ in range(N)]

    for row_idx in range(N):
        row = list(map(int, input().split()))
        for col_idx in range(N):
            cur = row[col_idx]
            row_sums[row_idx] += cur
            col_sums[col_idx] += cur

    for _ in range(M):
        r1, c1, r2, c2, v = map(int, input().split())
        r1 -= 1
        c1 -= 1
        for row_idx in range(r1, r2):
            row_sums[row_idx] += (c2 - c1) * v
        for col_idx in range(c1, c2):
            col_sums[col_idx] += (r2 - r1) * v

    print(" ".join(map(str, row_sums)))
    print(" ".join(map(str, col_sums)))
