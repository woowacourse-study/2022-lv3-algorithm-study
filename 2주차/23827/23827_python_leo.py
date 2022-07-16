import sys

answer = 0
N = int(sys.stdin.readline())
array = list(map(int, sys.stdin.readline().split()))
total = sum(array)
for i in array[:-1]:
    total -= i
    answer += i * total
print(answer % 1000000007)
