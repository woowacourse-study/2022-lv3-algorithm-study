# moomooomoomoooomoomooomoo
# 01234567890123456789012345
# 0 3 7 10 15 18 22 25

import sys
from bisect import bisect_left
from collections import deque
input = sys.stdin.readline

limit = 10**9

# 초기 수열 개수 설정
# 3, 10, 25...
lst = deque([3])
adder = 3
while True:
    adder = adder*2+1
    lst.append(lst[-1]+adder)
    if lst[-1] > limit:
        break


n = int(input()) # 11
k = bisect_left(lst, n) # 2
n -= 1           # 10 (0부터 시작)
# 분할정복
def fun(k, n): # 2, 11
    # 종료조건
    if n in lst:
        print("m")
        return
    if k == 0:
        if n==0:
            print("m")
        else:
            print("o")
        return
    # 중간 부분 체크(반복X)
    first_limit = (lst[k] - k - 3) / 2  # 10
    second_limit = first_limit + k + 2 # 14
    if first_limit <= n <= second_limit:
        if n==first_limit:
            print("m")
        else:
            print("o")
        return
    # 분할 부분
    if n < first_limit:
        fun(k-1, n)
    elif n > second_limit:
        fun(k-1, n-second_limit-1)

fun(k, n)
