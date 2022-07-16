import sys

n = int(sys.stdin.readline())
li = list(map(int, sys.stdin.readline().split()))
sum = sum(li)
result = 0

for l in li:
    sum -= l
    result += sum * l

print(result % 1000000007)
