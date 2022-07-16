from collections import deque

N = int(input())
students = list(map(int, input().split()))

waiting_stack = []
done = []
answer = [i for i in range(1, N+1)]

for i in range(len(students)):
    while waiting_stack and waiting_stack[-1] == len(done) + 1:
        done.append(waiting_stack.pop())
    if students[i] == len(done) + 1:
        done.append(students[i])
    else:
        waiting_stack.append(students[i])

while waiting_stack:
    done.append(waiting_stack.pop())

if answer == done:
    print("Nice")
else:
    print("Sad")
