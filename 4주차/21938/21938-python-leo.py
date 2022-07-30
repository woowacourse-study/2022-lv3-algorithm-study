import sys

input = sys.stdin.readline

sys.setrecursionlimit(10**6)


def pop(i, j):
    if i < 0 or j < 0 or i >= N or j >= M:
        return

    if new_display[i][j]:
        new_display[i][j] = False
        pop(i + 1, j)
        pop(i - 1, j)
        pop(i, j + 1)
        pop(i, j - 1)


def solution(T, display):
    T = T * 3
    for j in range(N):
        for i in range(M):
            index = i * 3
            if display[j][index] + display[j][index + 1] + display[j][index + 2] >= T:
                new_display[j].append(True)
            else:
                new_display[j].append(False)
    answer = 0
    for j in range(N):
        for i in range(M):
            if new_display[j][i]:
                answer += 1
                pop(j, i)
    return answer


N, M = map(int, input().split())
new_display = [[] for _ in range(N)]
display = []
for _ in range(N):
    display.append(list(map(int, input().split())))
T = int(input())
print(solution(T, display))