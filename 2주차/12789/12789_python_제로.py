import sys
from collections import deque

n = int(sys.stdin.readline())
dequeLst = deque(map(int, sys.stdin.readline().split()))  # 왼쪽 뽑는 기본 deque
checkLst = []  # deque에서 뽑힌 추가로 저장된 아래진영
current = 1  # 시작 번호

for i in range(n):  # deque
    left = dequeLst.popleft()
    if left == current:
        current += 1
        for _ in range(len(checkLst)):  # 추가진영
            if checkLst[-1] == current:
                current += 1
                checkLst.pop()

        continue
    checkLst.append(left)

answer = "Nice"
for index, value in enumerate(checkLst):
    if index != len(checkLst) - 1 and checkLst[index] <= checkLst[index + 1]:
        answer = "Sad"
        break

print(answer)
