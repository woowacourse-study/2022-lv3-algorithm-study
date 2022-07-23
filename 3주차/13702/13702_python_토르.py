from collections import deque
import sys

# 주전자의 개수 N, 친구들의 수 K
N, K = map(int, input().split())
drinks = [int(input()) for _ in range(N)]

left, right = 0, sys.maxsize
answer = 0


def calc_drink(mid):
    people_count = 0
    for drink in drinks:
        people_count += (drink // mid)
    return people_count

while left <= right:
    mid = (left + right) // 2
    dividable_people_count = calc_drink(mid)

    if dividable_people_count < K:
        right = mid - 1
    else:
        answer = max(answer, mid)
        left = mid + 1

print(answer)