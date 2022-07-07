import sys

input = sys.stdin.readline

n = int(input())
mountains = list(map(int, input().split()))

lower_mountain_count = 0
current_position = 0
latest_max_score = 0

for m in mountains:
    if current_position <= m:
        current_position = m
        latest_max_score = max(latest_max_score, lower_mountain_count)
        lower_mountain_count = 0
    else:
        lower_mountain_count += 1

print(max(latest_max_score, lower_mountain_count))


