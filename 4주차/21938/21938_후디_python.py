N, M = list(map(int, input().split()))

rgb = []
for i in range(N):
    row = list(map(int, input().split()))
    row_avg = []

    sum = 0
    for j, number in enumerate(row):
        sum += number
        if (j + 1) % 3 == 0:
            row_avg.append(sum // 3)
            sum = 0

    rgb.append(row_avg)

T = int(input())

new_rgb = []
for row in rgb:
    for num in row:
        new_rgb.append(num > T)

graph = []
for i, num in enumerate(new_rgb):
    graph.append([])

    if i % M != 0 and i - 1 >= 0 and new_rgb[i - 1]:
        graph[i].append(i - 1)

    if (i + 1) % M != 0 and i + 1 < len(new_rgb) and new_rgb[i + 1]:
        graph[i].append(i + 1)

    if i - M >= 0 and new_rgb[i - M]:
        graph[i].append(i - M)

    if i + M < len(new_rgb) and new_rgb[i + M]:
        graph[i].append(i + M)

def dfs(graph, node):
    visited.append(node)
    for neighbor in graph[node]:
        if neighbor not in visited:
            dfs(graph, neighbor)

visited = []
count = 0
for node in range(len(graph)):
    if node not in visited and new_rgb[node]:
        count += 1
        dfs(graph, node)

print(count)
