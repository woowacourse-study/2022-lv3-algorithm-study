import sys

input = sys.stdin.readline

N = int(input())
cards = list(map(int, input().split()))
LIS = [1] * N
for i in range(1, N):
    for j in range(i):
        if cards[i] > cards[j]:
            LIS[i] = max(LIS[i], LIS[j]+1)

print(max(LIS))
