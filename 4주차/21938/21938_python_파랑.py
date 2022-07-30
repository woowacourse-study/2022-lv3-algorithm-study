# 21938 영상처리
# ⚠️ visited 배열과 new screen 배열을 따로 두지 않는다.

import sys

readline = sys.stdin.readline
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def make_new_screen(n, m, screen, t):
    t *= 3
    new_screen = [[False] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if sum(screen[i][j * 3:j * 3 + 3]) >= t:
                new_screen[i][j] = True
    return new_screen


def check_object(sx, sy, screen):
    targets = {(sx, sy)}
    while targets:
        x, y = targets.pop()
        screen[x][y] = False
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and screen[nx][ny]:
                targets.add((nx, ny))


n, m = map(int, readline().split())
screen = [list(map(int, readline().split())) for _ in range(n)]
t = int(readline())

new_screen = make_new_screen(n, m, screen, t)
result = 0
for i in range(n):
    for j in range(m):
        if not new_screen[i][j]:
            continue
        result += 1
        check_object(i, j, new_screen)

print(result)
