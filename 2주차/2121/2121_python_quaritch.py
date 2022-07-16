# 2121번
# 넷이 놀기

import sys
readline = sys.stdin.readline

N = int(readline())
A, B = map(int, readline().rstrip().split())

coordinates = set()

for i in range(N):
    x, y = map(int, readline().rstrip().split())
    coordinates.add((x, y))

count = 0

for x, y in coordinates:
    if (x + A, y) in coordinates and (x, y + B) in coordinates and (x + A, y + B) in coordinates:
        count += 1

print(count)
