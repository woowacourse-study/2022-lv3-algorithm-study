import sys

input = sys.stdin.readline

n = int(input())
seq = list(map(int, input().split()))
tot = sum(seq)
res = 0

for num in seq:
    tot -= num
    res += num * tot
print(res % 1000000007)


