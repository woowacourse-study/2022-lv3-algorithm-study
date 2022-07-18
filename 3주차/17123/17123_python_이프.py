import sys
input = sys.stdin.readline

IDX = -1

for _ in range(int(input())):
    size, times = map(int, input().split())

    rows = [0] * size
    cols = [0] * size

    for row in range(size):
        items = input().split()
        for col in range(size):
            item = int(items[col])
            rows[row] += item
            cols[col] += item

    for __ in range(times):
        r1, c1, r2, c2, v = map(int, input().split())
        for i in range(r1 - 1, r2):
            rows[i] += v * (c2 - c1 + 1)
        for i in range(c1 - 1, c2):
            cols[i] += v * (r2 - r1 + 1)

    print(*rows)
    print(*cols)
