import sys

input = sys.stdin.readline

N = int(input())
chickens = list(map(int, input().split()))
K = int(input())

group_size = N // K
partially_sorted = []

for i in range(K):
    start = i * group_size
    end = (i+1) * group_size
    partially_sorted += sorted(chickens[start:end])

print(" ".join(map(str, partially_sorted)))
