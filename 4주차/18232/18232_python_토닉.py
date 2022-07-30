import sys
from collections import deque, defaultdict

input = sys.stdin.readline

N, M = map(int, input().rstrip().split())

start, target = map(int, input().rstrip().split())

teleports = defaultdict(list)
for _ in range(M):
    a, b = map(int, input().rstrip().split())
    teleports[a].append(b)
    teleports[b].append(a)

deq = deque([start])
times = [-1] * (N+1)
times[start] = 0
while deq:
    now = deq.popleft()
    now_move = [now-1, now+1]
    if now in teleports:
        now_move += teleports[now]
    for m in now_move:
        if (1 <= m <= N) and times[m] == -1:
            deq.append(m)
            times[m] = times[now]+1
        if m == target:
            print(times[m])
            exit()
