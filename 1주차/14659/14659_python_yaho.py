import sys
readline = sys.stdin.readline()

n = int(readline())
heights = list(map(int, readline().strip().split()))

result, count, max_height = 0
for height in heights:
    if height > max_height:
        max_height = height
        count = 0
    else:
        count += 1
        result = max(result, count)

print(result)
