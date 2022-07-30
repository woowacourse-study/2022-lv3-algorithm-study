from collections import deque

n = int(input())
inputLst = deque(list(map(int, input().split())))

checkScore = 0
answer = 0
def dfs(lst):
    global checkScore, answer
    # 양끝단만 남았을 때 계산하지 않음
    if len(lst) == 2:
        return
    for i in range(1, len(lst) - 1):
        findNum = lst[i]
        score = lst[i - 1] * lst[i + 1]
        checkScore += score
        # 계산한 점수 중 가장 큰 값
        answer = max(answer, checkScore)
        # 1개씩 빼며 dfs
        del lst[i]
        dfs(lst)
        # 원상복구
        checkScore -= score
        lst.insert(i, findNum)

dfs(inputLst)
print(answer)