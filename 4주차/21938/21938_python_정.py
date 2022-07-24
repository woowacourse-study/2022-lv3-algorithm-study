import sys

sys.setrecursionlimit(10**6) # 킹받네
input = sys.stdin.readline

N, M = map(int, input().split())
RGB = [list(map(int, input().split())) for _ in range(N)]
T = int(input())

object_map = [[False] * M for _ in range(N)]

for row_idx in range(N):
    for col_idx in range(M):
        start_col = col_idx * 3
        if sum(RGB[row_idx][start_col:start_col+3]) >= T * 3:
            object_map[row_idx][col_idx] = True

vis = [[False] * M for _ in range(N)]
count = 0

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(row_idx, col_idx):
    for i in range(4):
        next_row = row_idx + dy[i]
        next_col = col_idx + dx[i]
        if next_row < 0 or next_row >= N: continue
        if next_col < 0 or next_col >= M: continue
        if vis[next_row][next_col]: continue
        vis[next_row][next_col] = True 
        if object_map[next_row][next_col]:
            bfs(next_row, next_col)

for row_idx in range(N):
    for col_idx in range(M):
        if vis[row_idx][col_idx]: continue
        vis[row_idx][col_idx] = True
        if object_map[row_idx][col_idx]:
            count += 1
            bfs(row_idx, col_idx)

print(count)
