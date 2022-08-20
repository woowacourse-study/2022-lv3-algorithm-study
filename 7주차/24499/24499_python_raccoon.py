import sys

input = sys.stdin.readline

k, n = map(int, input().split())
apple_pies = list(map(int, input().split()))
left = 0
right = n - 1
middle_sum = sum(apple_pies[:n])
answer = 0

for i in range(k):
    middle_sum -= apple_pies[left]
    left = (left + 1) % k
    right = (right + 1) % k
    middle_sum += apple_pies[right]
    answer = max(answer, middle_sum)

print(answer)
