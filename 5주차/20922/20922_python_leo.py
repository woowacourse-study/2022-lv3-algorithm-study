from sys import stdin
from collections import defaultdict

input = stdin.readline

def solution(N, K, numbers):
    count_current = 0
    answer = 0
    number_dict = defaultdict(int)

    start_index = 0
    end_index = 0

    while end_index < len(numbers):
        if number_dict[numbers[end_index]] < K:
            number_dict[numbers[end_index]] += 1
            end_index += 1
            count_current += 1
            answer = max(answer, count_current)
        else:
            answer = max(answer, count_current)
            number_dict[numbers[start_index]] -= 1
            count_current -= 1
            start_index += 1

    return answer


N, K = map(int, input().split())
numbers = list(map(int, input().split()))

print(solution(N, K, numbers))
