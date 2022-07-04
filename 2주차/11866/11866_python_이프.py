from collections import deque

size, step = map(int, input().split())

queue = deque([str(i) for i in range(1, size+1)])

answer = []

try:
    while size:
        for i in range(step-1):
            queue.append(queue.popleft())
        answer.append(queue.popleft())

except IndexError:
    pass

answer = "<" + ", ".join(answer) + ">"

print(answer)

