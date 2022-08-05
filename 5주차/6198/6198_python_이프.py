import sys

readLine = sys.stdin.readline


def solution():
    size = int(input())
    buildings = [int(input()) for _ in range(size)][::-1]
    limits = [-1] * size

    for now in range(1, size):
        building = buildings[now]
        prev = now - 1
        while True:
            limits[now] = prev
            if prev == -1 or buildings[prev] >= building:
                break
            prev = limits[prev]

    answer = sum([i for i in range(size)]) - sum(limits) - size
    return answer

print(solution())
