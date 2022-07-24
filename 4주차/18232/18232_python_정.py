N, M = map(int, input().split())
start, end = map(int, input().split())

teleports = {}
for i in range(1, N+1):
     teleports[i] = []
for _ in range(M):
    x, y = map(int, input().split())
    teleports[x].append(y)
    teleports[y].append(x)

positions = [start]
vis = [True] + [False] * N
vis[start] = True
moves = 0

while vis[end] == False:
    moves += 1
    new_positions = []
    for pos in positions:
        left = pos - 1
        right = pos + 1
        destinations = [left, right] + teleports[pos]
        for dest in destinations:
            if dest == 0 or dest == N + 1: continue 
            if vis[dest]: continue
            vis[dest] = True
            new_positions.append(dest)
    positions = new_positions
            
print(moves)
