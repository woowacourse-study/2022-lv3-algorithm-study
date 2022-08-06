import sys

readLine = sys.stdin.readline


def solution(links):
    nodes = list(links.keys())
    result = 0

    while nodes:
        prev = nodes[0]

        visited = {prev}
        while len(visited) <= len(nodes):
            node = links[prev]
            if node in visited:
                result += 1
                break
            if node not in nodes:
                break
            visited.add(node)
            prev = node

        nodes = list(set(nodes) - visited)
    return result


if __name__ == "__main__":
    index = 1
    while True:
        size = int(readLine())
        if size == 0:
            break

        links = dict()
        for _ in range(size):
            a, b = readLine().split()
            links[a] = b

        print(index, solution(links))
        index += 1
