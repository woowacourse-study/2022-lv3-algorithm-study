import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
lst = []
for i in range(n):
    lst.append(int(input()))

q = deque([lst[0]])
answer = 0
for i in range(1, n):
    # 1. 현재 지정된 lst[i]보다 작은 값을 q에서 제거
    while q:
        if q[-1] > lst[i]:
            break
        q.pop()
    # 2. 저장
    q.append(lst[i])
    answer += (len(q) - 1)
print(answer)