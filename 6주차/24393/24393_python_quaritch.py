# 24393번
# 조커 찾기

import sys
import itertools as it

readline = sys.stdin.readline

deck = [i for i in range(1, 28)]

N = int(readline())

for _ in range(N):
    A = list(map(int, readline().rstrip().split()))
    left = []
    right = []

    for i in range(len(A)):
        if i % 2 == 0:
            right.append(A[i])
            continue
        left.append(A[i])

    temp = []
    for i in range(1, len(left) + 1):
        temp.append(sum(left[:i]))
    left = temp

    temp = []
    for i in range(1, len(right) + 1):
        temp.append(sum(right[:i]))
    right = temp

    idx = []
    for i in range(len(left)):
        idx.append(right[i])
        idx.append(left[i])
    if len(right) > len(left):
        idx.append(right[-1])

    left, right = deck[:13], deck[13:]

    new_deck = right[:A[0]] + left[:A[1]]
    for i in range(len(A) - 2):
        if i % 2 == 0:
            new_deck += right[idx[i]:idx[i + 2]]
            continue
        new_deck += left[idx[i]:idx[i + 2]]
    deck = new_deck

print(deck.index(1) + 1)
