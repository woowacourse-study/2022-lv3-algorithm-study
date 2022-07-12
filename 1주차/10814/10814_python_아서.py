import sys

input = sys.stdin.readline

n = int(input())
m = []
for _ in range(n):
    m.append(list(input().split()))
m.sort(key=lambda x: int(x[0]))
for x in m:
    print(int(x[0]), x[1])
