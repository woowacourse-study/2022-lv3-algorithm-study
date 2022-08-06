import sys

input = sys.stdin.readline

n = int(input())
chickens = list(map(int, input().split()))
k = int(input())

idx = n // k
res = []

for i in range(0, n, idx):
    res.extend(sorted(chickens[i:i + idx]))

print(*res)
