import sys

n = int(sys.stdin.readline())
tops = list(map(int, sys.stdin.readline().split()))

result = count = max_top = 0
for top in tops:
    if top > max_top:
        count = 0
    else:
        count += 1
        result = max(result, count)
    max_top = max(max_top, top)

print(result)