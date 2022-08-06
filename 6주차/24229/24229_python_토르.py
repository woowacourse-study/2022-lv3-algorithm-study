from collections import deque
import sys
import copy
from collections import defaultdict
import heapq

N = int(input())
boards = []
for _ in range(N):
    board = list(map(int, input().split()))
    boards.append(board)

boards.sort()
last_jump = 0
answer = 0

for i in range(0, len(boards) -1):
    # 이후와 연결되는 경우
    if boards[i][1] >= boards[i+1][0]:
        continue
    # 이후와 연결되지 않는 경우
    else:
        run_distance = boards[i][1] - last_jump
        # 점프할 수 있는 경우
        if boards[i][1] + run_distance >= boards[i+1][0]:
            last_jump = boards[i+1][0]
        # 없는 경우
        else:
            print(f"last_jump, {last_jump}")
            print(f"cur_point, {boards[i][1]}")
            answer = boards[i][1]
            break

print(answer)
print(boards)