# 11866 요세푸스 문제 0

import sys
from collections import deque


# list 사용: 68ms
def method1(k, array):
    idx = 0
    result = []
    while len(array) > 0:
        idx += (k - 1)
        idx %= len(array)
        result.append(array.pop(idx))
    return result


# deque의 rotate 메서드 사용: 92ms
def method2(k, array):
    result = []
    linked_list = deque(array)
    while linked_list:
        linked_list.rotate(-(k - 1))
        result.append(linked_list.popleft())
    return result


n, k = map(int, sys.stdin.readline().split())
array = [str(x) for x in range(1, n + 1)]
result = method1(k, array)

print("<" + ", ".join(result) + ">")
