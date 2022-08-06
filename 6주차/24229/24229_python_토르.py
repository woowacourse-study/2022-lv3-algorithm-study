from collections import deque
import sys
import copy
from collections import defaultdict
import heapq

N = int(input())
roads = []

for _ in range(N):
    roads.append(tuple(map(int, input().split())))

roads.sort()
last_l, last_r = 0, 0
max_index = 0
answer = 0

for l, r in roads:
    # 이전과 겹치는 경우
    if l <= last_r:
        # 완전히 이전것과 겹치는 경우
        if r <= last_r:
            continue
        # 현재 오른쪽이 더 길기는 한 경우
        max_index = max(max_index, 2 * r - last_l)
    # 이전과 겹치지 않는 경우
    else:
        # 이전에 점프해서 도달하지 못하는 경우
        if max_index < l:
            break
        # 이전에 점프해서 도달할 수 있는 경우
        max_index = max(max_index, 2 * r - l)
        last_l = l

    last_r = r
    answer = max(r, answer)

print(answer)
