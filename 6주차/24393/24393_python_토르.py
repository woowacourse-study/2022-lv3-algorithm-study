from collections import deque
import sys
import copy
from collections import defaultdict

input = sys.stdin.readline
cards = [i for i in range(1, 28)]
N = int(input())
for _ in range(N):
    numbers = list(map(int, input().split()))
    left, right = cards[:13], cards[13:]
    tmp = []

    for i in range(len(numbers)):
        if i % 2 == 0:
            right_take = right[:numbers[i]]
            right = right[numbers[i]:]
            tmp.extend(right_take)
        else:
            left_take = left[:numbers[i]]
            left = left[numbers[i]:]
            tmp.extend(left_take)

    cards = tmp

print(cards.index(1) + 1)