import sys

n, k = map(int, sys.stdin.readline().split())
lst = list(range(1, n + 1))
visited = [False] * (n + 1)
current = k - 1
count = 0
answer = [lst[current]]
visited[current] = True

while len(answer) != n:
    current += 1
    if current >= n:
        current = n - current
    if not visited[current]:
        count += 1
    if count == k:
        answer.append(lst[current])
        visited[current] = True
        count = 0
print("<", end="")
print(*answer, sep=", ", end="")
print(">")
