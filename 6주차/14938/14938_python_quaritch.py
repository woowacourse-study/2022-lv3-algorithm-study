# 14938번
# 서강그라운드

import sys

readline = sys.stdin.readline
INF = 16

n, m, r = map(int, readline().rstrip().split())
items = list(map(int, readline().rstrip().split()))
distance = [[INF for _ in range(n)] for _ in range(n)]

for i in range(n):
    distance[i][i] = 0

for _ in range(r):
    a, b, l = map(int, readline().rstrip().split())

    distance[a - 1][b - 1] = l
    distance[b - 1][a - 1] = l

for i in range(n):
    for j in range(n):
        for k in range(n):
            if distance[j][k] > distance[j][i] + distance[i][k]:
                distance[j][k] = distance[j][i] + distance[i][k]

answer = 0

for i in range(n):
    total_items = 0
    for j in range(n):
        if distance[i][j] <= m:
            total_items += items[j]
    answer = max(answer, total_items)

print(answer)
