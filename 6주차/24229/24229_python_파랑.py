# 24229 모두싸인 출근길

import sys

readline = sys.stdin.readline

n = int(readline())
values = [tuple(map(int, readline().split())) for _ in range(n)]
values.sort()

# 판자 합치기
boards = []
left = 0
right = values[0][1]
for l, r in values:
    if l <= right:
        right = max(right, r)
    else:
        boards.append((left, right))
        left = l
        right = r
boards.append((left, right))

# 최대 이동 지점 구하기
max_r = 0
res = 0
for l, r in boards:
    if l <= max_r:
        res = max(res, r)
        max_r = max(max_r, r * 2 - l)
    else:
        break

print(res)
