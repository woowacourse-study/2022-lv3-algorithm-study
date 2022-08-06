import sys
from collections import defaultdict, deque
input = sys.stdin.readline

n, k = map(int, input().split())
lst = list(map(int, input().split()))

db = defaultdict(int)
q = deque()
dp = [0] * (n+1)
answer = 0
for index, value in enumerate(lst):
    q.append(value)
    db[value] += 1
    if (k+1) == db[value]:
        # 현재 위치가 마지막인 최장 연속 부분 수열로 맞춘다
        while True:
            pop = q.popleft()
            db[pop] -= 1
            if pop == value:
                break
    dp[index] = len(q)
print(max(dp))
