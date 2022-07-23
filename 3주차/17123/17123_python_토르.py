from collections import deque
import sys

T = int(input())

for _ in range(T):
    # N 줄에 걸쳐 2차원 배열 A
    N, M = map(int, input().split())
    array = [list(map(int, input().split())) for _ in range(N)]
    # cum_sum_array[0][i] = i번째 행의 총합
    # cum_sum_array[1][j] = j번째 열의 총합
    cum_sum_array = [[0]*N for _ in range(2)]
    for i in range(N):
        cum_sum_array[0][i] = sum(array[i])

    for i in range(N):
        cum_sum_array[1][i] = sum(array[m][i] for m in range(N))
    for _ in range(M):
        r1, c1, r2, c2, v = map(int, input().split())

        for i in range(r1-1, r2):
            cum_sum_array[0][i] += (c2 - c1 + 1) * v

        for i in range(c1-1, c2):
            cum_sum_array[1][i] += (r2 - r1 + 1) * v

    for i in range(2):
        print(*cum_sum_array[i])
