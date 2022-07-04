import sys

input = sys.stdin.readline

int(input())
mountains = list(map(int, input().split()))

biggest = 0
cur_streak = 0
max_streak = 0

for cur in mountains:
    if cur >= biggest:
        biggest = cur
        if cur_streak > max_streak:
            max_streak = cur_streak
        cur_streak = 0
        continue
    cur_streak += 1

print(max(max_streak, cur_streak))