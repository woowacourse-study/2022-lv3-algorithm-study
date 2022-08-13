import sys
from math import ceil

input = sys.stdin.readline


def dfs(now, cnt):
    global dist, endpoint, min_t

    if dist < cnt:
        dist = cnt
        endpoint = now
        min_t = visited[now]
    elif dist == cnt and visited[now] < min_t:
        endpoint = now
        min_t = visited[now]

    for nxt, time in graph[now]:
        if visited[nxt] == -1:
            visited[nxt] = visited[now] + time
            dfs(nxt, cnt + 1)


N, T = map(int, input().split())
graph = [[] for _ in range(N)]
for _ in range(N - 1):
    A, B, C = map(int, input().split())
    A -= 1
    B -= 1
    graph[A].append((B, C))
    graph[B].append((A, C))

dist, endpoint, min_t = 0, 0, int(1e9)
visited = [-1] * N
visited[0] = 0
dfs(0, 1)

visited = [-1] * N
dist, min_t = 0, int(1e9)
visited[endpoint] = 0
dfs(endpoint, 1)
print(ceil(min_t / T))
