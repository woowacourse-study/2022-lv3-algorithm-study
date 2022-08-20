# 13905번
# 세부

import sys
from collections import deque

readline = sys.stdin.readline

N, M = map(int, readline().rstrip().split())
S, E = map(int, readline().rstrip().split())
bridges = [list(map(int, readline().rstrip().split())) for _ in range(M)]
graph = [[] for _ in range(N + 1)]

for start, end, cost in bridges:
    graph[start].append([end, cost])
    graph[end].append([start, cost])


def bfs(expense):
    q = deque()
    visited = [0] * (N + 1)
    visited[S] = 1
    q.append(S)

    while q:
        x = q.popleft()
        if x == E:
            return True
        for dest, price in graph[x]:
            if expense <= price and not visited[dest]:
                visited[dest] = 1
                q.append(dest)
    return False


answer = 0
a, b = 1, 1_000_000

while a <= b:
    mid = (a + b) // 2
    if bfs(mid):
        answer = mid
        a = mid + 1
    else:
        b = mid - 1

print(answer)
