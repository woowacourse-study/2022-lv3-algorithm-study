def dfs(graph, node): # 순환여부를 boolean으로 반환
    global visited

    visited.append(node)
    if node not in graph.keys(): # 이 사람은 선행을 베풀지 않음
        return False

    neighbor = graph[node]
    if neighbor in visited: # 순환 발견
        return True

    return dfs(graph, neighbor)

cases = []
while True:
    N = int(input())
    if N == 0:
        break

    # 그래프 채우기
    graph = {}
    for i in range(N):
        giver, taker = input().split()
        graph[giver] = taker

    cases.append(graph)

for i, graph in enumerate(cases):
    start = list(graph.keys())[0]  # 탐색 시작점
    visited = []
    circular_count = 0
    for giver in graph:
        if giver in visited:
            continue

        is_circular = dfs(graph, giver)
        if is_circular:
            circular_count += 1

    print(i + 1, circular_count)
