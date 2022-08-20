import sys, math
from collections import defaultdict, deque

input = sys.stdin.readline


def bfs(start):
    global hour, end_point

    q = deque([(start, 1, 0)])  # 시작위치, 지난개수, 시간
    visited = [False] * (n + 1)
    visited[0] = True
    visited[start] = True
    checkLst = []

    while q:
        s, count, h = q.popleft()
        checkCount = count
        for e in lst[s]:
            if visited[e]:
                continue
            visited[e] = True
            checkCount = count + 1
            q.append((e, count + 1, h + distance[(s, e)]))
        if (False not in visited) and checkCount == count:
            if hour > h:
                end_point = s
                hour = h
            checkLst.append((count, h))
    return checkLst


# 입력
n, t = map(int, input().split())
# 갈 수 있는 방향정보
lst = defaultdict(list)

# 거리
distance = defaultdict(int)
for _ in range(n - 1):
    a, b, c = map(int, input().split())
    lst[a].append(b)
    lst[b].append(a)
    distance[(a, b)] = c
    distance[(b, a)] = c

end_point = 0
hour = 1e9
bfs(1)
hour = 1e9
checkLst = bfs(end_point)
temp = sorted(checkLst, key=lambda x: (-x[0], x[1]))
hour = temp[0][1]
print(math.ceil(hour / t))
