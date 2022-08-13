from collections import deque
import sys
import copy
from collections import defaultdict
import heapq

# 집 개수, 다리 수
input = sys.stdin.readline
n, m = map(int, input().split())
# 출발, 도착
s, e = map(int, input().split())
answer = 0

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    h1, h2, k = map(int, input().split())
    graph[h1].append((k, h2))
    graph[h2].append((k, h1))


left, right = 1, 1000000


def solve(max_carry):
    queue = deque([s])
    visited = [False] * (n+1)
    visited[s] = True

    while queue:
        cur_pos = queue.popleft()

        if cur_pos == e:
            return True

        for adj_cost, adj_node in graph[cur_pos]:
            if not visited[adj_node] and max_carry <= adj_cost:
                queue.append(adj_node)
                visited[adj_node] = True

    return False


while left <= right:
    mid = (left + right) // 2
    if solve(mid):
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)