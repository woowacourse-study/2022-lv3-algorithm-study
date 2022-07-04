n = int(input())
lst = list(map(int, input().split()))

answer = 0
maxNum = 0
cnt = 0

for i in lst:
    # 6 4 / 10 2 5 7 / 11
    if i > maxNum:
        maxNum = i
        cnt = 0
    else:
        cnt += 1
    answer = max(answer, cnt)

print(answer)