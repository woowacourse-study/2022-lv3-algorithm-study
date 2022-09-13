import sys

input = sys.stdin.readline

n = int(input())

def get_initial_shuffle_result(joker): 
    (_, joker_idx) = joker
    if joker_idx < 13:
        return (-1, joker_idx)
    return (1, joker_idx - 13)

joker = (0, 0) # left: (-1, idx) / right: (1, idx)

for i in range(n):
    nums = list(map(int, input().split()))
    joker = get_initial_shuffle_result(joker)
    result = 0

    for idx in range(len(nums)):
        (pos, joker_idx) = joker
        if pos == 0:
            continue
        
        num = nums[idx]
        if pos == 1 and idx%2 == 0:
            if joker_idx + 1 <= num:
                joker = (0, result + joker_idx)
                continue
            joker = (pos, joker_idx - num)
        if pos == -1 and idx%2 == 1:
            if joker_idx + 1 <= num:
                joker = (0, result + joker_idx)
                continue
            joker = (pos, joker_idx - num)
        result += num

(pos, joker_idx) = joker

print(joker_idx + 1)

