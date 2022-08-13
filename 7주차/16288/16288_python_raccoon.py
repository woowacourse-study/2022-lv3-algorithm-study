import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())
sequence = list(map(int, input().split()))
waitings = [deque() for _ in range(k)]
current_person = 1

for seq in sequence:
    for waiting in waitings:
        if not waiting:
            waiting.append(seq)
            break
        if waiting and waiting[-1] < seq:
            waiting.append(seq)
            break
    else:
        print("NO")
        sys.exit(0)

print("YES")
