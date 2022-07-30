# 16198번
# 에너지 모으기

import sys

readline = sys.stdin.readline

N = int(readline())
W = list(map(int, readline().rstrip().split()))


def dfs(energies):
    if len(energies) == 3:
        return energies[0] * energies[2]
    answer = 0
    for i in range(1, len(energies) - 1):
        product = energies[i - 1] * energies[i + 1]
        total = product + dfs(energies[:i] + energies[i + 1:])
        answer = max(answer, total)
    return answer


print(dfs(W))
