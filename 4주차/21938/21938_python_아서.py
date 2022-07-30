import sys
from collections import deque

input = sys.stdin.readline


def bfs(a, b):
    queue = deque()
    queue.append((a, b))
    v[a][b] = False

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if v[nx][ny] and pic[nx][ny] >= t:
                    queue.append((nx, ny))
                    v[nx][ny] = False


n, m = map(int, input().split())
pic = []

for _ in range(n):
    tmp = list(map(int, input().split()))
    tmp_li = []
    for i in range(m):
        tmp_li.append(sum(tmp[3 * i: 3 * (i + 1)]))
    pic.append(tmp_li)

t = int(input()) * 3

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

v = [[True for _ in range(m)] for _ in range(n)]

cnt = 0
for i in range(n):
    for j in range(m):
        if pic[i][j] >= t and v[i][j]:
            bfs(i, j)
            cnt += 1
print(cnt)
