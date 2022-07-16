# 12789번
# 도키도키 간식드리미

from collections import deque
import sys
readline = sys.stdin.readline

N = int(readline())
students = deque(map(int, readline().rstrip().split()))
waiting = deque()
order = 1

while students:
    waiting.append(students.popleft())
    while waiting and waiting[-1] == order:
        waiting.pop()
        order += 1

print("Sad" if waiting else "Nice")
