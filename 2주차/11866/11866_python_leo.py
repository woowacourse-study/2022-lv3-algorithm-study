import sys


N, K = map(int, sys.stdin.readline().split())
K -= 1
circle = list(range(1, N + 1))
answer = []
index = 0
for _ in range(N):
    index = (index + K) % len(circle)
    answer.append(circle.pop(index))

print(f"<{', '.join(map(str, answer))}>", end="")
