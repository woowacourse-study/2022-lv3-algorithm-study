import sys

n = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split()))

reverseLst = lst[::-1]
answerLst = [reverseLst[0]]
for i in range(1, n - 1):
    answerLst.append(answerLst[i - 1] + reverseLst[i] % 1_000_000_007)
answerLst = answerLst[::-1]

answer = 0
for i in range(n-1):
    answer += lst[i] * answerLst[i] % 1_000_000_007

print(answer % 1_000_000_007)
