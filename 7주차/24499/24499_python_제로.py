import sys

input = sys.stdin.readline

n, k = map(int, input().split())
lst = list(map(int, input().split()))
dp = [0] * len(lst)
lst = lst + lst
dp[0] = sum(lst[n - k + 1:n + 1])
for i in range(1, len(dp)):
    dp[i] = dp[i-1] + lst[i+n] - lst[i+n-k]
print(max(dp))