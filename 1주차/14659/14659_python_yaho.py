import sys

n = int(sys.stdin.readline())
heights = list(map(int, sys.stdin.readline().strip().split()))

tmp = 0
for i in range(n-1):
    if tmp == n - i:
        break
    now = heights[i]
    cnt = 0
    for j in range(i+1, n):
        if heights[j] <= now:
            break
        cnt += 1
    tmp = max(tmp, cnt)

print(tmp)
