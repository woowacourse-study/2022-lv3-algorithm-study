# 18232 텔레포트 정거장

import sys
from collections import deque

readline = sys.stdin.readline

n, m = map(int, readline().split())
s, e = map(int, readline().split())
teleport = [[] for _ in range(n + 1)]
for _ in range(m):
    x, y = map(int, readline().split())
    teleport[x].append(y)
    teleport[y].append(x)

visited = [0] * (n + 1)
targets = deque([s])
while True:
    x = targets.popleft()
    if x == e:
        print(visited[e])
        break
    for nx in (x - 1, x + 1, *teleport[x]):
        if 0 < nx <= n and not visited[nx]:
            visited[nx] = visited[x] + 1
            targets.append(nx)
