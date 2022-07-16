import sys

readline = sys.stdin.readline

t = int(readline())

for _ in range(t):
    n, m = map(int, readline().split())
    li = [list(map(int, readline().split())) for _ in range(n)]
    li_r = [sum(r) for r in li]
    li_c = [sum(c) for c in list(zip(*li))]

    for _ in range(m):
        r1, c1, r2, c2, v = map(int, readline().split())
        for r in range(r1-1, r2):
            li_r[r] += (c2-c1+1) * v
        for c in range(c1-1, c2):
            li_c[c] += (r2-r1+1) * v

    print(*li_c)
    print(*li_r)
