import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
cards = [1] + [0] * 26
left = cards[:13]
right = cards[13:]

for _ in range(n):
    seq = list(map(int, input().split()))
    left = cards[:13]
    right = cards[13:]
    new_cards = []
    for i in range(len(seq)):
        if i % 2 == 0:
            new_cards.extend(right[:seq[i]])
            right = right[seq[i]:]
        else:
            new_cards.extend(left[:seq[i]])
            left = left[seq[i]:]
    cards = new_cards

print(cards.index(1) + 1)
