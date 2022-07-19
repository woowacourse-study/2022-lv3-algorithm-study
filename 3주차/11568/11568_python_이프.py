import sys
input = sys.stdin.readline

def solution():
    dp = [0] * 1001

    size = int(input())
    numbers = [int(i) for i in input().split()]

    for i in range(size):
        number = numbers[i]
        dp[i] = 1 + max([dp[j] for j in range(i) if numbers[j] < number] + [0])

    return max(dp)

print(solution())
