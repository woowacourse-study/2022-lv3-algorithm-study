# 23827 수열 (Easy)

import sys

readline = sys.stdin.readline

n = int(readline())
array = list(map(int, readline().split()))

sum = sum(array)
res = 0
for num in array[::-1]:
    sum -= num
    res += sum * num
    res %= 1000000007

print(res)
