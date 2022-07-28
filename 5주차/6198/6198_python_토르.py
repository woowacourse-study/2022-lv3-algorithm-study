from collections import deque
import sys
import copy
from collections import defaultdict

N = int(input())
buildings = [int(input()) for _ in range(N)]

stack = []
answer = [0] * len(buildings)

for i in range(len(buildings)):
    while stack and buildings[stack[-1]] <= buildings[i]:
        index = stack.pop()
        answer[index] = i - index - 1

    stack.append(i)

while stack:
    index = stack.pop()
    answer[index] = len(buildings) - index - 1

print(sum(answer))