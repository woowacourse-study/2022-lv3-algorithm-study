# 2121 넷이 놀기

import sys

readline = sys.stdin.readline

n = int(readline())
a, b = map(int, readline().split())
points = set(tuple(map(int, readline().split())) for _ in range(n))

res = 0
for x, y in points:
    if (x + a, y) in points and (x + a, y + b) in points and (x, y + b) in points:
        res += 1

print(res)
