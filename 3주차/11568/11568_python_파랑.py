# 11568 민균이의 계략

import sys

readline = sys.stdin.readline

n = int(readline())
cards = list(map(int, readline().split()))

count = [1] * n
for i in range(1, n):
    for j in range(i):
        if cards[j] < cards[i]:
            count[i] = max(count[i], count[j] + 1)

print(max(count))
