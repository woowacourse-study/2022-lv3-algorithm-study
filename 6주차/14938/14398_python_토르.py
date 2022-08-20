from collections import deque
import sys
import copy
from collections import defaultdict
import heapq

# 지역의 개수 n, 수색 범위 m, 길의 개수 r
n, m, r = map(int, input().split())

items = list(map(int, input().split()))
graph = [[] for _ in range(n)]

answer = 0


def dijkstra(start_node):
    global answer
    distances = [sys.maxsize] * len(items)
    distances[start_node] = 0
    priority_queue = []
    heapq.heappush(priority_queue, (0, start_node))

    while priority_queue:
        cost, node = heapq.heappop(priority_queue)

        for adj_node_cost in graph[node]:
            adj_cost = adj_node_cost[0]
            adj_node = adj_node_cost[1]

            if adj_cost + cost < distances[adj_node]:
                distances[adj_node] = adj_cost + cost
                heapq.heappush(priority_queue, (cost + adj_cost, adj_node))

    item_count = 0
    for i in range(n):
        if distances[i] <= m:
            item_count += items[i]

    answer = max(answer, item_count)

for _ in range(r):
    a, b, l = map(int, input().split())
    a -= 1
    b -= 1
    graph[a].append((l, b))
    graph[b].append((l, a))

    for i in range(len(items)):
        dijkstra(i)

print(answer)
