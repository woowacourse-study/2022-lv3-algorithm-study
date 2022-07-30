import sys
from collections import deque

input = sys.stdin.readline
n, m = map(int, input().split())
s, e = map(int, input().split())
db = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, input().split())
    db[x].append(y)
    db[y].append(x)

def bfs(start):
    q = deque()
    q.append((start, 0))
    while q:
        # 현재위치, 시간
        x, hop = q.popleft()
        # 검증
        if x == e:
            return hop
        if 1 <= x <= n:
            if not visited[x]:
                visited[x] = True
                q.append((x-1, hop+1))
                q.append((x+1, hop+1))
                if len(db[x]) > 0:
                    for y in db[x]:
                        q.append((y, hop+1))

print(bfs(s))
