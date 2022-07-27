import sys, copy

readLine = sys.stdin.readline


def solution(size, balls):
    if size == 2:
        return 0

    answer = 0
    for i in range(1, size - 1):
        other = copy.deepcopy(balls)
        other.pop(i)

        result = balls[i - 1] * balls[i + 1] + solution(size - 1, other)
        if answer <= result:
            answer = result
    return answer


if __name__ == "__main__":
    size = int(readLine())
    balls = list(map(int, readLine().split()))

    print(solution(size, balls))
