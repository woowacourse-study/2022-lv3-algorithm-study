import sys

input = sys.stdin.readline


def solution(N, number_tickets):
    goal_number = 1
    stack = [N + 1]
    for i in number_tickets:
        while goal_number == stack[-1]:
            stack.pop()
            goal_number += 1
        if i == goal_number:
            goal_number += 1
        elif i < stack[-1]:
            stack.append(i)
        else:
            return "Sad"
    return "Nice"


print(solution(int(input()), list(map(int, input().split()))))
