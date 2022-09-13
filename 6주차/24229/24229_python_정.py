import sys

input = sys.stdin.readline

N = int(input())

roads = []

for _ in range(N):
    a, b = map(int, input().split())
    roads.append((a, b))

roads.sort()

connections = []
cur_start = -1
cur_max = -1
for idx in range(N):
    (a, b) = roads[idx]
    if cur_start == -1:
        cur_start = a
        cur_max = b
    if b <= cur_max: continue
    if a <= cur_max and cur_max <= b:
        cur_max = b
        continue
    connections.append((cur_start, cur_max))
    cur_start = a
    cur_max = b

connections.append((cur_start, cur_max))

max_jumpable = 0
max_reached = 0

for (left, right) in connections:
    if max_jumpable < left: break 

    max_jump_length = right - left
    max_jumpable = max(max_jumpable, right + max_jump_length)
    max_reached = max(max_reached, right)

print(max_reached)
