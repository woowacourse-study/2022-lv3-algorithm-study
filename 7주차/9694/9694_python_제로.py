import sys, heapq
from collections import defaultdict

input = sys.stdin.readline

def dijkstra(start):
    q = []
    distance[start] = 0
    heapq.heappush(q, (0, start)) # 거리, 위치

    while q:
        d, now = heapq.heappop(q)
        if d > distance[now]:
            continue
        for next_d, next_now in graph[now]:
            cost = next_d + d
            if distance[next_now] > cost:
                distance[next_now] = cost
                route[next_now] = now # 이전 경로를 저장
                heapq.heappush(q, (cost, next_now))

t = int(input())
for test in range(1, t+1):
    n, m = map(int, input().split())
    graph = defaultdict(list)
    for i in range(n):
        x, y, z = map(int, input().split())
        graph[x].append((z, y))
        graph[y].append((z, x))

    distance = [1e9] * m
    route = [-1] * m # 경로
    dijkstra(0)
    if distance[-1] == 1e9:
        print("Case #{0}: -1".format(test))
        continue
    # 경로 구하기
    path = []
    curr = m-1
    while curr:
        path.append(curr)
        curr = route[curr]
    path.append(0) # 초기 추가
    print('Case #{0}: {1}'.format(test, ' '.join(str(_) for _ in path[::-1])))
