import sys

n = int(sys.stdin.readline())
a, b = map(int, sys.stdin.readline().split())
li = []
for i in range(n):
    li.append(tuple(map(int, sys.stdin.readline().split())))
li = set(li)
cnt = 0

for x, y in li:
    if (x+a, y) in li and (x, y+b) in li and (x+a, y+b) in li:
        cnt += 1

print(cnt)
