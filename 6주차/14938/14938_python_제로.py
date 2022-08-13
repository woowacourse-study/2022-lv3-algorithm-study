import heapq, sys
from collections import defaultdict

input = sys.stdin.readline


def dijstra(start):
    distance = [1e9] * (n + 1)
    distance[start] = 0
    q = []
    heapq.heappush(q, (0, start))
    while q:
        d, now = heapq.heappop(q)
        if d > distance[now]:
            continue
        for next_d, next_now in graph[now]:
            if distance[next_now] > d + next_d:
                distance[next_now] = d + next_d
                heapq.heappush(q, (d + next_d, next_now))
    return distance


n, m, r = map(int, input().split())
lst = list(map(int, input().split()))
graph = defaultdict(list)
for _ in range(r):
    start, end, dist = map(int, input().split())
    graph[start].append((dist, end))
    graph[end].append((dist, start))

answer = 0
for i in range(1, n+1):
    count = 0
    checkDijstra = dijstra(i)[1:]
    for i in range(len(checkDijstra)):
        if checkDijstra[i] <= m:
            count+=lst[i]
    answer = max(answer, count)
print(answer)
