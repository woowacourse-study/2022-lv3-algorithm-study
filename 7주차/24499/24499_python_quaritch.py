# 24499번
# blobyum

import sys

readline = sys.stdin.readline

N, K = map(int, readline().rstrip().split())
A = list(map(int, readline().rstrip().split()))
A += A

l, r = 0, K
tmp = sum(A[:K])
ans = 0

for _ in range(N):
    tmp += A[r] - A[l]
    ans = max(ans, tmp)
    l += 1
    r += 1

print(ans)
