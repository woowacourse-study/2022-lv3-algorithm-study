import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
lst = []
# rgb 평균값으로 저장
for _ in range(n):
    tempLst = list(map(int, input().split()))
    rgbLst = []
    for i in range(0, m*3, 3):
        rgbLst.append(sum(tempLst[i:i+3])/3)
    lst.append(rgbLst)
t = int(input())

dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]
def bfs(i, j):
    q = deque()
    q.append((i, j))
    while q:
        new_i, new_j = q.popleft()
        for index in range(4):
            ni = dx[index] + new_i
            nj = dy[index] + new_j
            if not (0 <= ni < n and 0 <= nj < m):
                continue
            if lst[ni][nj] >= t:
                q.append((ni, nj))
                lst[ni][nj] = -1
count = 0
for i in range(n):
    for j in range(m):
        if lst[i][j] >= t:
            count += 1
            lst[i][j] = -1
            bfs(i, j)
print(count)