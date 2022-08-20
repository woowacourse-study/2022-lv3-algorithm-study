import sys
input = sys.stdin.readline


def solution():
    size, count = map(int, input().split())
    numbers = list(map(int, input().split()))

    if size == count:
        return sum(numbers)

    total = sum(numbers[size - count:])
    answer = total

    for i in range(size - 1, -2, -1):
        left, right = numbers[i - count], numbers[i]
        total = total + left - right
        answer = max(answer, total)

    return answer


print(solution())
