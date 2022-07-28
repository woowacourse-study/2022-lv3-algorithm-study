from collections import deque
import sys
import copy
from collections import defaultdict

N = int(input())
chickens = list(map(int, input().split()))
k = int(input())
answer = []
section = len(chickens) // k

for i in range(0, len(chickens), section):
    part = chickens[i: i + section]
    answer.extend(sorted(part))

print(" ".join(map(str, answer)))