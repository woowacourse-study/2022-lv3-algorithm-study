# 실패 : 시간초과가 나옵니다.. 근데 다른 풀이가 떠오르지 않아여...
import sys

readline = sys.stdin.readline

n, k = map(int, readline().split())
li = [int(readline()) for _ in range(n)]

cnt = 0
result = max(li)

while cnt != k:
    share = [li[i]//result for i in range(n)]
    cnt = sum(share)
    if cnt == k:
        break
    result = max([li[i]//(share[i]+1) for i in range(n)])

print(result)
