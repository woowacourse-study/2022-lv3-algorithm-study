import sys
import heapq

input = sys.stdin.readline

heights = []
count = 0

for cur_idx in range(int(input())):
    cur_height = int(input())
    while heights:
        lowest = heapq.heappop(heights)
        if lowest > cur_height: 
            heapq.heappush(heights, lowest)
            count += len(heights)
            break
    heapq.heappush(heights, cur_height)

print(count)

# ============================

# 근데 시간초과가 나는 경우는 제 풀이가 틀린게 아니라 느려터진 컴퓨터가 틀린게 아닐까요?

# timeover_solution 2
# N = int(input())
# cur_idx = 0
# count = 0
# heights = []

# def calculate(cur_height):
#     global heights
#     global count
#     heights_num = len(heights) 

#     if heights_num == 0 or max(heights) > cur_height:
#         heights.append(cur_height)
#         return
    
#     for left_idx in range(heights_num):
#         left = heights[left_idx]
#         for right_idx in range(left_idx + 1, heights_num):
#             right = heights[right_idx]
#             if left <= right: break
#             count += 1
#     heights = [cur_height]

# for _ in range(N):
#     cur_height = int(input())
#     calculate(cur_height)

# calculate(9_999_999_999)
# print(count)

# timeover_solution 1
def timeover_solution1():
    N = int(input())
    heights = [0] * N
    counts = [0] * N
    can_see_idx = []

    for cur_idx in range(N):
        cur_height = int(input())
        heights[cur_idx] = cur_height
        new_can_see_idx = []
        for building_idx in can_see_idx:
            if heights[building_idx] > cur_height:
                counts[building_idx] += 1
                new_can_see_idx.append(building_idx)

        new_can_see_idx.append(cur_idx)
        can_see_idx = new_can_see_idx

    print(sum(counts))
