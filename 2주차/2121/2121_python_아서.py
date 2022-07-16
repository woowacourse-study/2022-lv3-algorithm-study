import sys

input = sys.stdin.readline

n = int(input())
a, b = map(int, input().split())
dots = set(tuple(map(int, input().split())) for _ in range(n))

res = 0
for (x, y) in dots:
    if (x + a, y) not in dots: continue
    if (x, y + b) not in dots: continue
    if (x + a, y + b) not in dots: continue
    res += 1
print(res)
