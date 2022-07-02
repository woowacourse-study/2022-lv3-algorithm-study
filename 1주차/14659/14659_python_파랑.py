import sys

readline = sys.stdin.readline

n = int(readline())
tops = list(map(int, readline().split()))

result = count = max_top = 0
for top in tops:
    if top > max_top:
        count = 0
        max_top = top
    else:
        count += 1
        result = max(result, count)

print(result)
