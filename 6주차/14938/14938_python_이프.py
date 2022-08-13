import sys
from heapq import heappop, heappush

input = sys.stdin.readline


def solution():
    node_count, limit, line_count = map(int, input().split())
    nodes = {node: worth for node, worth in zip(range(1, node_count+1),list(map(int, input().split())))}

    graph = {node: [] for node in nodes.keys()}
    for _ in range(line_count):
        a, b, distance = map(int, input().split())
        graph[a].append((b,distance))
        graph[b].append((a,distance))


    def find(start, nodes):
        visited = {node: False for node in nodes}
        distances = {node: float('inf') for node in nodes}
        distances[start] = 0

        targets = [(start, 0)]
        while targets:
            target, this_distance = heappop(targets)
            if visited[target]:
                continue
            visited[target] = True

            next_nodes = graph[target]
            for node, distance in next_nodes:
                next_distance = this_distance + distance
                if next_distance > limit:
                    continue
                distances[node] = min(next_distance, distances[node])
                heappush(targets, (node, distances[node]))

        return sum([nodes[node] for node, distance in distances.items() if distance <= limit])

    return max([find(start, nodes) for start in nodes.keys()])


print(solution())
