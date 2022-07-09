# 14659번
# 한조서열정리하고옴ㅋㅋ

import sys
readline = sys.stdin.readline

N = int(readline())
peaks = list(map(int, readline().split()))

highest = count = result = 0

for peak in peaks:
    if peak > highest:
        highest = peak
        count = 0
        continue
    count += 1
    result = max(result, count)

print(result)
