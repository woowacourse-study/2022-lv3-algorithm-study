from collections import deque

N, K = map(int, input().split())

people = [i for i in range(1, N+1)]
queue = deque(people)
answer = []

while queue:
    queue.rotate(- (K - 1))
    answer.append(queue.popleft())

content = ", ".join(map(str, answer))
print(f"<{content}>")
