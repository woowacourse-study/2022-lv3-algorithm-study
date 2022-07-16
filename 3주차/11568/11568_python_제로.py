import copy
import sys
from collections import defaultdict
from bisect import bisect_left

n = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split(" ")))
sortedLst = copy.deepcopy(lst)
sortedLst.sort()
dicts = defaultdict(int)

# 입력값으로 초기화
for i in sortedLst:
    dicts[i] = 0

for i in lst:
    # 앞에서부터 현재값 이전까지 값 구하기
    keys = list(dicts.keys())
    findValues = list(dicts.values())[0:bisect_left(keys, i)]
    # 기존 없다면 기본값
    if (len(findValues)) == 0:
        dicts[i] = 1
        continue
    # 이전치의 최고보다 1 더한다
    dicts[i] = max(findValues) + 1
print(max(dicts.values()))
