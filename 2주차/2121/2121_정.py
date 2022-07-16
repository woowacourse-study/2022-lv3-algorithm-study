import sys

input = sys.stdin.readline

N = int(input())
A, B = map(int, input().split())

dot_map = {}

for _ in range(N):
    (left_x, bottom_y) = map(int, input().split())
    right_x = left_x + A
    top_y = bottom_y + B

    if (left_x, bottom_y) not in dot_map:
        dot_map[(left_x, bottom_y)] = 1
    else:
        dot_map[(left_x, bottom_y)] += 1

    if (right_x, bottom_y) not in dot_map:
        dot_map[(right_x, bottom_y)] = 1
    else:
        dot_map[(right_x, bottom_y)] += 1

    if (left_x, top_y) not in dot_map:
        dot_map[(left_x, top_y)] = 1
    else:
        dot_map[(left_x, top_y)] += 1

    if (right_x, top_y) not in dot_map:
        dot_map[(right_x, top_y)] = 1
    else:
        dot_map[(right_x, top_y)] += 1

answer = 0
for dot_count in dot_map.values():
    if dot_count == 4:
        answer += 1

print(answer)
