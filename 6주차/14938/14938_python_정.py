import sys

input = sys.stdin.readline

n, max_move, r = map(int, input().split())
items = [0] + list(map(int, input().split()))

route = {}
for i in range(1, n+1):
    route[i] = []

# DFS solution
for _ in range(r):
    a, b, l = map(int, input().split())
    route[a].append((l, b))
    route[b].append((l, a))

def dfs(cur_pos, moved):
    global visited
    for (length, next_pos) in route[cur_pos]:
        total_move = moved + length
        if total_move > max_move: 
            continue
        visited[next_pos] = True
        dfs(next_pos, total_move)

max_count = 0
for start in range(1, n+1):
    visited = [False] * (n+1)
    visited[start] = True
    dfs(start, 0)
    count = 0
    for idx in range(1, n+1):
        if visited[idx]:
            count += items[idx]
    max_count = max(count, max_count)

print(max_count)
