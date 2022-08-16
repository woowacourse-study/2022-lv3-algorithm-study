import sys
import heapq

input = sys.stdin.readline
INT_MAX = int(10e9)

t = int(input())


def dijkstra(graph, start):
    heap = []
    distance = [INT_MAX] * len(graph)
    parents = [-1] * len(graph)
    heapq.heappush(heap, [0, start])
    distance[0] = 0

    while heap:
        dist, node = heapq.heappop(heap)
        if distance[node] != dist:
            continue
        for cost, next_node in graph[node]:
            if distance[node] + cost < distance[next_node]:
                distance[next_node] = distance[node] + cost
                heapq.heappush(heap, [distance[next_node], next_node])
                parents[next_node] = node

    return distance, parents


for i in range(t):
    n, m = map(int, input().split())
    graph = [[] for _ in range(m)]

    for j in range(n):
        src, dest, cost = map(int, input().split())
        graph[src].append([cost, dest])
        graph[dest].append([cost, src])

    distance, parents = dijkstra(graph, 0)
    if distance[m - 1] == INT_MAX:
        print("Case #{0}: -1".format(i + 1))
        continue

    end = m - 1
    path = []
    while end != 0:
        path.append(end)
        end = parents[end]
    else:
        path.append(end)

    print("Case #{0}: {1}".format(i + 1, " ".join(map(str, path[::-1]))))
