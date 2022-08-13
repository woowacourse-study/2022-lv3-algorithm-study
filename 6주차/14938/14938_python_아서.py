import sys

input = sys.stdin.readline

n, m, r = map(int, input().split())
items = list(map(int, input().split()))
board = list([sys.maxsize] * n for _ in range(n))

for _ in range(r):
    a, b, l = map(int, input().split())
    board[a - 1][b - 1] = min(board[a - 1][b - 1], l)
    board[b - 1][a - 1] = min(board[b - 1][a - 1], l)

for c in range(n):
    for a in range(n):
        for b in range(n):
            if a == b:
                board[a][b] = 0
            else:
                board[a][b] = min(board[a][b], board[a][c] + board[c][b])

res = 0
for i in range(n):
    tmp = 0
    for j in range(n):
        if board[i][j] <= m:
            tmp += items[j]
    res = max(tmp, res)
print(res)
