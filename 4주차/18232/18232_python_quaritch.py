# 18232번
# 텔레포트 정거장

from collections import deque
import sys

readline = sys.stdin.readline


def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = 1
    while q:
        x = q.popleft()

        dx = [x + 1, x - 1]

        if teleports[x]:
            dx += teleports[x]

        for nx in dx:
            if 0 < nx <= N and visited[nx] == 0:  # 범위 내 이면서 방문하지 않았을 경우
                visited[nx] = visited[x] + 1  # 방문 처리 겸 초 계산
                q.append(nx)
            if x == E:  # 목표점에 도달했을 경우
                return visited[x] - 1


N, M = map(int, readline().rstrip().split())
S, E = map(int, readline().rstrip().split())
teleports = [[] for _ in range(N + 1)]
visited = [0] * (N + 1)
for _ in range(M):
    a, b = map(int, readline().rstrip().split())
    teleports[a].append(b)
    teleports[b].append(a)

print(bfs(S))
