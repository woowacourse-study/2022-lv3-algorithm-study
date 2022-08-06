from collections import deque
import sys
import copy
from collections import defaultdict

# S(k)는 S(k-1)과 o가 k+2개인 수열 "m o ... o" 와 S(k-1)을 합쳐서 만들 수 있다.
# https://tesseractjh.tistory.com/101

N = int(input())

cur_length, k = 3, 0
while N > cur_length:
    k += 1
    cur_length = cur_length * 2 + k + 3

def moo(cur_length, middle_length, N):
    left_length = (cur_length - middle_length) // 2
    if N <= left_length:
        return moo(left_length, middle_length - 1, N)
    elif N > left_length + middle_length:
        return moo(left_length, middle_length - 1, N - left_length - middle_length)
    else:
        return "o" if N - left_length - 1 else "m"

print(moo(cur_length, k + 3, N))
