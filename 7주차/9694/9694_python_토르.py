from collections import deque
import sys
import copy
from collections import defaultdict
import heapq

T = int(input())
# 관계의 수, 정치인 수
for test_number in range(T):
    N, M = map(int, input().split())
    graph = [[] for _ in range(M)]

    for _ in range(N):
        x, y, z = map(int, input().split())
        graph[x].append((z, y))
        graph[y].append((z, x))

    answer = -1

    def dijkstra(start, history):
        distances = [[sys.maxsize, ""] for _ in range(M)]
        distances[start][0] = 0
        distances[start][1] = "0"
        heap = []
        heapq.heappush(heap, (0, start, "0"))

        while heap:
            cur_cost, cur_pos, cur_history = heapq.heappop(heap)

            for adj_cost, adj_node in graph[cur_pos]:
                if cur_cost + adj_cost < distances[adj_node][0]:
                    distances[adj_node][0] = cur_cost + adj_cost
                    distances[adj_node][1] = cur_history + " " + str(adj_node)
                    heapq.heappush(heap, (cur_cost + adj_cost, adj_node, cur_history + " " + str(adj_node)))

        if distances[M-1][0] != sys.maxsize:
            return distances[M-1][1]
        return -1

    print(f"Case #{test_number+1}: {dijkstra(0, '')}")