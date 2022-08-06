from collections import deque
import sys
import copy
from collections import defaultdict

round = 1
count = 0

def bfs(start_name, name_dict, visited_bfs):
    visited = set()
    queue = deque()
    queue.append(name_dict[start_name])
    while queue:
        cur_name = queue.pop()
        visited.add(cur_name)
        visited_bfs.add(cur_name)
        if cur_name == start_name:
            return True

        next_name = name_dict[cur_name]
        if next_name not in visited:
            queue.append(next_name)

    return False


while True:
    N = int(input())
    count = 0
    if N == 0:
        exit()
    name_dict = dict()

    for i in range(1, N+1):
        a, b = input().split()
        name_dict[a] = b

    from_names = list(name_dict.keys())
    visited_bfs = set()

    for i in range(len(from_names)):
        if from_names[i] not in visited_bfs:
            visited_bfs.add(from_names[i])
            result = bfs(from_names[i], name_dict, visited_bfs)
            if result:
                count += 1

    print(round, count)
    round += 1