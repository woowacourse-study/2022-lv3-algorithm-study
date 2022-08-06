from collections import deque
import sys
import copy
from collections import defaultdict

N, K = map(int, input().split())
numbers = list(map(int, input().split()))
number_dict = defaultdict(int)

left, right = 0, 0
max_length = 0
cur_length = 0

while right < len(numbers):
    if number_dict[numbers[right]] < K:
        number_dict[numbers[right]] += 1
        right += 1
        cur_length += 1
        max_length = max(max_length, cur_length)

    else:
        max_length = max(max_length, cur_length)
        cur_length -= 1
        number_dict[numbers[left]] -= 1
        left += 1

print(max_length)
