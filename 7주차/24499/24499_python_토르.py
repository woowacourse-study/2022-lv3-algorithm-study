from collections import deque
import sys
import copy
from collections import defaultdict

input = sys.stdin.readline
N, K = map(int, input().split())
pies = list(map(int, input().split()))
answer = 0

cur_pies = []
tmp_sum = 0
left, right = 0, 0

while len(cur_pies) < K:
    cur_pies.append(pies[right])
    tmp_sum += pies[right]
    right += 1
    if right >= len(pies):
        right %= len(pies)

answer = max(answer, tmp_sum)

for _ in range(len(pies)):
    tmp_sum += pies[right]
    tmp_sum -= pies[left]

    answer = max(answer, tmp_sum)
    right += 1
    left += 1

    if right >= len(pies):
        right %= len(pies)

print(answer)