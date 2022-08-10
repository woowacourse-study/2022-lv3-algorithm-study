# 25391번
# 특별상

import sys

readline = sys.stdin.readline

N, M, K = map(int, readline().rstrip().split())
scores = [tuple(map(int, readline().rstrip().split())) for _ in range(N)]
referee = sorted(scores, key=lambda x: -x[1])
organizer = sorted(referee[K:], key=lambda x: -x[0])
print(sum([x[0] for x in referee[:K]]) + sum([x[0] for x in organizer[:M]]))
