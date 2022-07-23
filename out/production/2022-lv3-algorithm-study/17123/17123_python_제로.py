# 전체입력
t = int(input())
for i in range(t):
    # 초기입력
    n, m = map(int, input().split())
    lst = [list(map(int, input().split())) for _ in range(n)]
    exceedLst = [list(map(int, input().split())) for _ in range(m)]

    # 행합
    answer1 = []
    for i in lst:
        answer1.append(sum(i))
    # 열합
    answer2 = []
    for i in range(n):
        count = 0
        for j in range(n):
            count += lst[j][i]
        answer2.append(count)

    for i in exceedLst:
        r1, c1, r2, c2, v = i
        # 행값 추가
        for index in range(r1-1, r2):
            answer1[index] += (c2-c1+1) * v
        # 열값 추가
        for index in range(c1-1, c2):
            answer2[index] += (r2-r1+1) * v

    print(' '.join(str(i) for i in answer1))
    print(' '.join(str(i) for i in answer2))