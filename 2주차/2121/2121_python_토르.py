from collections import deque

N = int(input())
A, B = map(int, input().split()) # 가로 길이, 세로 길이
coordinates = set()

for _ in range(N):
    x, y = map(int, input().split())
    coordinates.add((x, y))

answer = 0

for coordinate in coordinates:
    saved_x, saved_y = coordinate

    if (saved_x - A, saved_y) in coordinates and (saved_x, saved_y - B) in coordinates and (saved_x - A, saved_y - B) in coordinates:
        answer += 1
    if (saved_x + A, saved_y) in coordinates and (saved_x, saved_y - B) in coordinates and (saved_x + A, saved_y - B) in coordinates:
        answer += 1
    if (saved_x + A, saved_y) in coordinates and (saved_x, saved_y + B) in coordinates and (saved_x + A, saved_y + B) in coordinates:
        answer += 1
    if (saved_x - A, saved_y) in coordinates and (saved_x - A, saved_y + B) in coordinates and (saved_x, saved_y + B) in coordinates:
        answer += 1

print(answer // 4) # 사각형이 만들어진다면 사각형의 각 꼭지점에서 다 answer를 올렸기 때문에 나눠줍니다.