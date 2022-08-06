import sys
from collections import defaultdict
input = sys.stdin.readline

index = 1
while True:
    n = int(input())
    # 종료 설정
    if n == 0:
        exit(0)
    print(index, end=' ')
    index += 1
    lst = defaultdict(bool)

    # 로직시작
    count = 0
    # n개 입력받기
    for _ in range(n):
        a, b = map(str, input().split())
        # 둘다 True면 count 증가
        if lst[a] == True and lst[b] == True:
            count += 1
        else:
            lst[a] = True
            lst[b] = True
    print(count)