# 17362번
# 수학은 체육과목 입니다 2

import sys
readline = sys.stdin.readline

remainder = int(readline()) % 8

if remainder == 0:
    print(2)
elif remainder == 7:
    print(3)
elif remainder == 6:
    print(4)
else:
    print(remainder)
