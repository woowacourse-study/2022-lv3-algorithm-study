# 23827번
# 수열 (Easy)

import sys
readline = sys.stdin.readline

N = int(readline())
A = list(map(int, readline().rstrip().split()))
sum = sum(A)
answer = 0

for number in A:
    sum -= number
    answer += number * sum

print(answer % 1000000007)
