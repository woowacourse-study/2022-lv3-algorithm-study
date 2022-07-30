# 21938번
# 영상처리

from collections import deque
import sys

readline = sys.stdin.readline


def bfs(x, y):
    q = deque()
    q.append((x, y))
    rgb[x][y] = 0
    while q:
        x, y = q.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < N and 0 <= ny < M:  # 범위 내일 때
                if rgb[nx][ny] == 1:  # 물체가 이어져 있을 경우
                    q.append([nx, ny])
                    rgb[nx][ny] = 0  # 방문 처리


dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

N, M = map(int, readline().rstrip().split())
raw_rgb = [list(map(int, readline().rstrip().split())) for _ in range(N)]
T = int(readline())
rgb = [[1 if sum(raw_line[j:j + 3]) / 3 >= T else 0 for j in range(0, len(raw_line), 3)] for raw_line in raw_rgb]

ans = 0

for i in range(N):
    for j in range(M):
        if rgb[i][j] == 1:
            bfs(i, j)
            ans += 1

print(ans)
