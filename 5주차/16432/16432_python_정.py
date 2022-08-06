import sys

input = sys.stdin.readline

N = int(input())
cake_types = []
visited = [[False] * 10 for _ in range(N)]

for day in range(N):
    _, *types = map(int, input().split())
    cake_types.append(types)

cur_cake_types = []
answer = -1

def dfs(day, prev_type):
    global answer
    if day == N:
        answer = list(cur_cake_types)
        return 

    for cur_type in cake_types[day]:
        if cur_type == prev_type: continue
        if visited[day][cur_type]: continue
        if answer != -1: return
        visited[day][cur_type] = True # 같은 경로 반복하지 않도록 
        cur_cake_types.append(cur_type)        
        dfs(day + 1, cur_type)
        cur_cake_types.pop()

dfs(0, -1)

if answer == -1:
    print(-1)
else:
    print("\n".join(map(str, answer)))

# ======================================

# Time Over Solution : DFS without visited

# N = int(input())
# cake_types = []

# for day in range(N):
#     _, *types = map(int, input().split())
#     cake_types.append(types)

# cur_cake_types = []
# answer = -1

# def dfs(day, prev_type):
#     global answer
#     if day == N:
#         answer = list(cur_cake_types)
#         return 

#     for cur_type in cake_types[day]:
#         if cur_type == prev_type: continue
#         if answer != -1: return
#         cur_cake_types.append(cur_type)
#         dfs(day + 1, cur_type)
#         cur_cake_types.pop()

# dfs(0, -1)

# if answer == -1:
#     print(-1)
# else:
#     print("\n".join(map(str, answer)))
