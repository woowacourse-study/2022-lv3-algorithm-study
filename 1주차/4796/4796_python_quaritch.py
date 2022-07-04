# 4796번
# 캠핑

import sys
readline = sys.stdin.readline

case = 0
while True:
    L, P, V = map(int, readline().rstrip().split())
    if V == 0:
        break
    case += 1
    print(f'Case {case}: {V // P * L + min(L, V % P)}')
