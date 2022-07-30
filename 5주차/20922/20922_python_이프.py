import sys

readLine = sys.stdin.readline


def solution():
    length, limit = map(int, readLine().split())
    numbers = [int(i) for i in input().split()]

    locations, counts = dict(), dict()

    answer = 0
    start = -1
    for now in range(length):
        number = numbers[now]
        if number not in locations:
            locations[number] = list()
            counts[number] = 0

        locations[number].append(now)
        counts[number] += 1

        count = counts[number]
        if count > limit:
            start = max(start, locations[number].pop(0))
            counts[number] -= 1
        answer = max(answer, now - start)

    return answer

print(solution())
