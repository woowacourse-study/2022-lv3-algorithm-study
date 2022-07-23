import sys
input = sys.stdin.readline

def search(cups, target):
    start = 1
    end = max(cups)

    result = 0
    while (start <= end):
        mid = (start + end) // 2

        count = sum([cup // mid for cup in cups])
        if (count >= target):
            result = mid
            start = mid + 1
        else:
            end = mid -1

    return result


def solution():
    size, target = map(int, input().split())
    cups = [int(input()) for i in range(size)]
    return search(cups, target)

print(solution())
