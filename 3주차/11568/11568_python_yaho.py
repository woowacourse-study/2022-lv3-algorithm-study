# 실패 : 왜 틀렸는지 모르겠습니당...😭
import sys

readline = sys.stdin.readline

n = int(readline())
li = list(map(int, readline().split()))

max_cnt = 1
for i in range(n-1):
    if n-i <= max_cnt:
        break
    cnt = 1
    min = li[i]
    for x in li[i+1:]:
        if min < x:
            cnt += 1
            min = x
    max_cnt = max(cnt, max_cnt)

print(max_cnt)
