from collections import deque
import sys
import copy
from collections import defaultdict
import heapq

input = sys.stdin.readline

A, B, C = map(int, input().split())
a_numbers = sorted(list(map(int, input().split())))
b_numbers = sorted(list(map(int, input().split())))
c_numbers = sorted(list(map(int, input().split())))

answer = sys.maxsize
