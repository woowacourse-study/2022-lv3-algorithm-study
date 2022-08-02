import sys 

input = sys.stdin.readline

test_case = 0

while True:
    N = int(input())
    if N == 0: break
    test_case += 1

    vertex = set()
    edges = {}
    visited = {}
    loop_count = 0
    
    for _ in range(N):
        A, B = input().split()
        edges[A] = B
        vertex.add(A)
        vertex.add(B)
        visited[A] = visited[B] = False

    for v in vertex:
        start = edges[v]
        if visited[start]: continue
        visited[start] = True
        cur = start
        loop_count += 1
        while True:
            cur = edges[cur]
            visited[cur] = True
            if cur == start: break

    print(test_case, loop_count)
