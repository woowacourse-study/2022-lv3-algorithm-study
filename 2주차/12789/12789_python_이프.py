from collections import deque

NICE = "Nice"
SAD = "Sad"

def solution():

    size = int(input())

    queue = deque([int(i) for i in input().split()])
    stack = []

    moved = [False] * 1001
    target = 1

    while True:
        if (target == size):
            return NICE

        if (moved[target] == False):
            ticket = queue.popleft()
            if (ticket != target):
                stack.append(ticket)
                moved[ticket] = True
                continue

        else:
            ticket = stack.pop()
            if (ticket != target):
                return SAD

        target += 1

print(solution())
