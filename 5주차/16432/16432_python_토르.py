from collections import deque
import sys
import copy
from collections import defaultdict

# https://dalseoin.tistory.com/entry/%EB%B0%B1%EC%A4%80%ED%8C%8C%EC%9D%B4%EC%8D%AC-16432-%EB%96%A1%EC%9E%A5%EC%88%98%EC%99%80-%ED%98%B8%EB%9E%91%EC%9D%B4


input = sys.stdin.readline
N = int(input())

rice_cakes = [] * N
visited = [[False] * 10 for _ in range(N + 1)]
can_success = False

for _ in range(N):
    rice_cake = list(map(int, input().split()))[1:]
    rice_cakes.append(rice_cake)


def dfs(day, gave_rice_cakes):
    global can_success
    if can_success:
        return

    if day == N:
        print("\n".join(list(gave_rice_cakes)))
        can_success = True
        return

    for cake in rice_cakes[day]:
        if day == 0:
            visited[day + 1][cake] = True
            dfs(day + 1, gave_rice_cakes + str(cake))

        elif str(cake) != gave_rice_cakes[-1] and not visited[day + 1][cake]:
            visited[day + 1][cake] = True
            dfs(day + 1, gave_rice_cakes + str(cake))


dfs(0, '')

if can_success == False:
    print(-1)
