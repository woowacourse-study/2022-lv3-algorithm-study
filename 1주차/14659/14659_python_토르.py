import sys

N = int(input())
hills = list(map(int, input().split()))

current_height = 0
max_height = 0
count = 0
answer = 0

for i in range(len(hills)):
    if hills[i] > max_height:
        count = 0
        max_height = hills[i]
    else:
        count += 1

    answer = max(answer, count)

print(answer)