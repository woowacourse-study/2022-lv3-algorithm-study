from collections import deque
import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m = map(int, input().split())
s, e = map(int, input().split())
edges = []

for _ in range(m):
    h1, h2, k = map(int, input().split())
    edges.append([k, h1, h2])

edges.sort(key=lambda x: -x[0])


def union(parents, a1, a2):
    pa1 = find(parents, a1)
    pa2 = find(parents, a2)
    parents[pa1] = pa2


def find(parents, a1):
    if parents[a1] != a1:
        parents[a1] = find(parents, parents[a1])

    return parents[a1]


def kruskal(edges):
    global n

    graph = [[] for i in range(n+1)]
    parents = [i for i in range(n+1)]
    for count, src, dest in edges:
        if find(parents, src) != find(parents, dest):
            union(parents, src, dest)
            graph[src].append([dest, count])
            graph[dest].append([src, count])

    return graph


def bfs(graph, s, e):
    visited = set()
    queue = deque()
    visited.add(s)
    queue.append([s, sys.maxsize])

    while queue:
        cn, current_node_count = queue.popleft()
        if cn == e:
            return current_node_count

        for nn, next_node_count in graph[cn]:
            if nn not in visited:
                visited.add(nn)
                queue.append([nn, min(next_node_count, current_node_count)])
    
    return 0


graph = kruskal(edges)
print(bfs(graph, s, e))
