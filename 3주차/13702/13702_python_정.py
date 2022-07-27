import sys

input = sys.stdin.readline

N, K = map(int, input().split())
nums = [int(input()) for _ in range(N)]

start = 1
end = max(nums)
mid = (start + end) // 2

while start <= end:
    total = 0
    for num in nums:
        total += num // mid

    if total >= K:
        start = mid + 1
    else:
        end = mid - 1 # total < K가 되는 경계선에서 하나 빼기
    mid = (start + end) // 2

print(end)
