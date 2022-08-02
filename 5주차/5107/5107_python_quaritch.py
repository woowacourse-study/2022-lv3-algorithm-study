# 5107번
# 마니또

import sys

readline = sys.stdin.readline


def dfs(name):
    global answer
    if not targeting[name][1]:
        targeting[name][1] = True
        dfs(targeting[name][0])
    else:
        answer += 1
        return


trial = 1

while True:
    N = int(readline())
    if N == 0:
        break
    targeting = {}
    answer = 0

    for _ in range(N):
        manito, target = readline().rstrip().split()
        targeting[manito] = [target, False]

    for manito in targeting:
        if not targeting[manito][1]:
            dfs(manito)

    print(trial, answer)
    trial += 1
