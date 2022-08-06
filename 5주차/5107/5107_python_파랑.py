# 5107 마니또

import sys
from collections import defaultdict

readline = sys.stdin.readline

case = 1
n = int(readline())
while n:
    manito = defaultdict(bool)
    result = 0
    for _ in range(n):
        a, b = readline().split()
        if manito[a] and manito[b]:
            result += 1
            continue
        manito[a] = True
        manito[b] = True

    print("%d %d" % (case, result))
    case += 1
    n = int(readline())
