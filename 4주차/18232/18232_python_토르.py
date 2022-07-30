from collections import deque
import sys
import copy

# 1부터 N까지
N, M = map(int, sys.stdin.readline().split())
# S: 주예 시작 위치, E 주예 목적지
S, E = map(int, sys.stdin.readline().split())
teleports = [[] for _ in range(N+1)]
for _ in range(M):
    start, destination = map(int, sys.stdin.readline().split())
    teleports[start].append(destination)
    teleports[destination].append(start)

move_cost = [sys.maxsize] * (N + 1)
visited = [False] * (N + 1)
move_cost[S] = 0

def bfs(current_pos):
    queue = deque()
    queue.append((current_pos, 0))
    visited[current_pos] = True

    while queue:
        pos, cost = queue.popleft()
        if pos == E:
            move_cost[pos] = cost
            break

        if 1 <= pos - 1 <= N and not visited[pos - 1]:
            visited[pos - 1] = True
            move_cost[pos - 1] = cost + 1
            queue.append((pos - 1, cost + 1))

        if 1 <= pos + 1 <= N and not visited[pos + 1]:
            visited[pos + 1] = True
            move_cost[pos + 1] = cost + 1
            queue.append((pos + 1, cost + 1))

        for i in range(len(teleports[pos])):
            if 1 <= teleports[pos][i] <= N and not visited[list(teleports[pos])[i]]:
                visited[teleports[pos][i]] = True
                move_cost[teleports[pos][i]] = move_cost[pos] + 1
                queue.append((teleports[pos][i], cost + 1))

bfs(S)
print(move_cost[E])
