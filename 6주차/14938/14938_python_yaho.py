import sys

input = sys.stdin.readline

N, m, r = map(int, input().split())
item = [0] + list(map(int, input().split()))

arr = [[sys.maxsize for _ in range(N + 1)] for _ in range(N + 1)]

for i in range(N + 1):
    arr[i][i] = 0

for _ in range(r):
    a, b, dist = map(int, input().split())
    arr[a][b] = dist
    arr[b][a] = dist

for k in range(N + 1):
    for i in range(N + 1):
        for j in range(N + 1):
            if arr[i][j] > arr[i][k] + arr[k][j]:
                arr[i][j] = arr[i][k] + arr[k][j]

answer = 0

for i in range(1, N + 1):
    can_get_item = [item[x] for x in range(1, N + 1) if arr[i][x] <= m]
    answer = max(answer, sum(can_get_item))

print(answer)
