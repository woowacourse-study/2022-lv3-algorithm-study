# 14938 서강그라운드

import sys
import heapq

readline = sys.stdin.readline

n, m, r = map(int, readline().split())
t = [0] + list(map(int, readline().split()))
path = [[] for _ in range(n + 1)]
for _ in range(r):
    a, b, l = map(int, readline().split())
    path[a].append([b, l])
    path[b].append([a, l])

res = 0
for s in range(1, n + 1):
    item_count = 0
    length = [sys.maxsize] * (n + 1)
    queue = [(s, 0)]
    length[s] = 0
    while queue:
        now, d = heapq.heappop(queue)
        for next, nd in path[now]:
            if d + nd < length[next] and d + nd <= m:
                length[next] = d + nd
                heapq.heappush(queue, (next, d + nd))
    for i in range(1, n + 1):
        if length[i] <= m:
            item_count += t[i]
    res = max(res, item_count)

print(res)
