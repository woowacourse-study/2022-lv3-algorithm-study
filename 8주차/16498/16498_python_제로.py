import sys
from bisect import bisect_left, bisect_right

input = sys.stdin.readline

a, b, c = map(int, input().split())
lstA = list(map(int, input().split()))
lstB = list(map(int, input().split()))
lstC = list(map(int, input().split()))
lstA.sort()
lstB.sort()
lstC.sort()

answer = 1e9
check = []
for a in lstA:
    b_index = bisect_left(lstB, a)
    c_index = bisect_left(lstC, a)
    check.append(a)
    for i in range(b_index - 1, b_index + 1):
        if b_index == b:
            continue
        check.append(lstB[i])
        for j in range(c_index - 1, c_index + 1):
            if c_index == c:
                continue
            check.append(lstC[j])
            answer = min(answer, (max(check)-min(check)))
            check.pop()
        check.pop()
    check.pop()
print(answer)