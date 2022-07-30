from collections import deque
import sys

# 세로, 가로
N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
new_board = [[0] * M for _ in range(N)]
visited = [[False] * M for _ in range(N)]
T = int(input())
count = 0

dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]

def print_board(board):
    for i in range(len(board)):
        for j in range(len(board[0])):
            print(board[i][j], end = " ")
        print()


for i in range(len(board)):
    for j in range(len(board[0])):
        if j % 3 == 0:
            if (board[i][j] + board[i][j + 1] + board[i][j + 2]) / 3 < T:
                new_board[i][j // 3] = 0
            else:
                new_board[i][j // 3] = 255
        else:
            continue


def bfs(i, j):
    queue = deque()
    visited[i][j] = True
    queue.append((i, j))

    while queue:
        y, x = queue.popleft()
        for k in range(4):
            ny, nx = y + dy[k], x + dx[k]
            if 0 <= ny < len(new_board) and 0 <= nx < len(new_board[0]):
                if new_board[ny][nx] == 255 and not visited[ny][nx]:
                    visited[ny][nx] = True
                    queue.append((ny, nx))



for i in range(len(new_board)):
    for j in range(len(new_board[0])):
        if not visited[i][j] and new_board[i][j] == 255:
            count += 1
            bfs(i, j)

print(count)
