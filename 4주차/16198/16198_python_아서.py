import sys

input = sys.stdin.readline


def find(sum):
    global max_sum
    if len(seq) == 2:
        if sum > max_sum:
            max_sum = sum
        return
    else:
        for i in range(1, len(seq) - 1):
            tmp_energy = seq[i - 1] * seq[i + 1]
            tmp = seq.pop(i)
            find(sum + tmp_energy)
            seq.insert(i, tmp)


n = int(input())
seq = list(map(int, input().split()))
max_sum = 0
find(0)
print(max_sum)
