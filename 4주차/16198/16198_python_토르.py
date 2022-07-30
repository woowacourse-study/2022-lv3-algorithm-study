from collections import deque
import sys
import copy

N = int(input())
max_sum = -sys.maxsize
balls = list(map(int, input().split()))


def back_tracking(balls, current_sum):
    global max_sum
    if len(balls) == 2:
        max_sum = max(max_sum, current_sum)
        return

    for i in range(1, len(balls) - 1):
        copy_balls = copy.copy(balls)
        tmp_add = copy_balls[i - 1] * copy_balls[i + 1]
        copy_balls.pop(i)
        back_tracking(copy_balls, current_sum + tmp_add)

back_tracking(balls, 0)
print(max_sum)
