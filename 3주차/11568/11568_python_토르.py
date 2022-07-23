from collections import deque
import sys

N = int(input())
numbers = list(map(int, input().split()))

# dp[i] = i번째 숫자를 포함하여 순증가하는 배열의 최대 길이
dp = [1] * len(numbers)

for i in range(1, len(numbers)):
    for j in range(i):
        if numbers[i] > numbers[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))