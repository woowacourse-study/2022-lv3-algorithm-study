from collections import deque
import sys

n = int(sys.stdin.readline())
queue = deque(map(int, sys.stdin.readline().split()))
stack = deque()
next = 1

while queue:
    if queue[0] == next:
        queue.popleft()
        next += 1
    else:
        stack.append(queue.popleft())
    while stack and stack[-1] == next:
        stack.pop()
        next += 1

print("Nice" if not stack else "Sad")
