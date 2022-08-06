import sys

input = sys.stdin.readline


def solution(n, m, r, items_count):
    distances = [[sys.maxsize] * n for _ in range(n)]
    for _ in range(r):
        a, b, length = map(int, input().split())
        distances[a - 1][b - 1] = min(distances[a - 1][b - 1], length)
        distances[b - 1][a - 1] = min(distances[b - 1][a - 1], length)

    for c in range(n):
        for a in range(n):
            for b in range(n):
                if a == b:
                    distances[a][b] = 0
                else:
                    distances[a][b] = min(distances[a][b], distances[a][c] + distances[c][b])
    answer = 0
    for a in range(n):
        current = 0
        for b in range(n):
            if distances[a][b] <= m:
                current += items_count[b]
        answer = max(answer, current)
    return answer


n, m, r = map(int, input().split())
items_count = list(map(int, input().split()))
print(solution(n, m, r, items_count))
