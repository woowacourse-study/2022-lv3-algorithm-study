import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]

    row_sum = [sum(row) for row in board]
    col_sum = [sum(col) for col in list(zip(*board))]

    for _ in range(m):
        r1, c1, r2, c2, v = map(int, input().split())
        for i in range(r1 - 1, r2):
            row_sum[i] += (c2 - c1 + 1) * v
        for i in range(c1 - 1, c2):
            col_sum[i] += (r2 - r1 + 1) * v

    print(*row_sum)
    print(*col_sum)
