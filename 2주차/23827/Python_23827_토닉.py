import sys

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().rstrip().split()))

A_sum = sum(A)
result = 0

for a in A:
    A_sum -= a
    result += a * A_sum

print(result % 1000000007)
