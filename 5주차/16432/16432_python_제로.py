import copy
import sys

input = sys.stdin.readline


def dfs(i, cakes, prevCake):
    # 완료 시점
    if i == n:
        for temp in cakes:
            print(temp)
        exit(0)
    # dfs
    for cake in lst[i]:
        # 방문한 적 없고, 이전 떡과 다를때
        if not visited[i+1][cake] and cake != prevCake:
            visited[i+1][cake] = True
            new_cakes = copy.deepcopy(cakes)
            new_cakes.append(cake)
            dfs(i + 1, new_cakes, cake)


n = int(input())
# 떡 정보
lst = []
for _ in range(n):
    lst.append(list(map(int, input().split()))[1:])
# [n번째날][떡 종류]
visited = [[False for _ in range(11)] for i in range(n + 1)]
dfs(0, [], 0)  # i번째날, 떡 넣는 리스트, 전날 먹은 떡
print(-1)
