import sys

input = sys.stdin.readline

n, k = map(int, input().split())
taste = list(map(int, input().split()))
taste += taste

lt = 0
psum = [0] * 2 * n
psum[k - 1] = sum(taste[:k])

for i in range(k, n + k):
    psum[i] = psum[i - 1] + taste[i] - taste[i - k]

print(max(psum))
