import sys

n, k = map(int, sys.stdin.readline().split(" "))
lst = [int(sys.stdin.readline()) for _ in range(n)]

left = 0
right = sum(lst)//k
middle = 0
# 최대 막걸리 양에서 이분탐색
while left <= right:
    count = 0
    # 몇명이 마실 수 있는지 검증
    middle = (left+right) // 2
    # 예외
    if middle == 0:
        middle += 1
    for j in lst:
        count += j//middle
    if k <= count:
        left = middle + 1
        continue
    right = middle -1
print(right)
