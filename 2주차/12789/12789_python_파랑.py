# 12789 도키도키 간식드리미

import sys

readline = sys.stdin.readline

n = int(readline())
line = list(map(int, readline().split()))
stack = []

now = 1
while now <= n:
    if line and line[0] == now:
        line.pop(0)
        now += 1
    elif stack and stack[-1] == now:
        stack.pop()
        now += 1
    else:
        if not line:
            print("Sad")
            exit(0)
        stack.append(line.pop(0))

print("Nice")
