from collections import deque

N = int(input())
numbers = list(map(int, input().split()))

answer = 0
MOD = 1000000007
total_sum = sum(numbers)
cum_sum = 0

for i in range(len(numbers)):
    cum_sum += numbers[i]
    answer += (numbers[i] * (total_sum - cum_sum)) % MOD

print((answer % MOD))
