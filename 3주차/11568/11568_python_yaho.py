import sys

readline = sys.stdin.readline

n = int(readline())
li = list(map(int, readline().split()))

cnt = [1] * n
for i in range(1, n):
    for j in range(i):
        if li[j] < li[i]:
            cnt[i] = max(cnt[i], cnt[j] + 1)

print(max(cnt))
