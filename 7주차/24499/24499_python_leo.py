import sys


input = sys.stdin.readline


def solution(pies, N, K):
    if N == K:
        return sum(pies)

    maximum = sum(pies[:K])
    answer = maximum
    for i in range(K, N):
        left_pie, right_pie = pies[i-K], pies[i]
        maximum += right_pie - left_pie
        answer = max(answer, maximum)
    for i in range(K - 1):
        start_pie, end_pie = pies[-K + i], pies[i]
        maximum += end_pie - start_pie
        answer = max(answer, maximum)
    return answer


N, K = map(int, input().split())
pies = list(map(int, input().split()))
print(solution(pies, N, K))
