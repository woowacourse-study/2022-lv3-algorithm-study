# 5904번
# Moo 게임

import sys

readline = sys.stdin.readline


def moo(total_length, middle_length, target):
    side_length = (total_length - middle_length) // 2

    if target <= side_length:
        return moo(side_length, middle_length - 1, target)

    if side_length < target <= total_length - side_length:
        return "o" if target - side_length - 1 else "m"

    if side_length + middle_length < target:
        return moo(side_length, middle_length - 1, target - side_length - middle_length)


N = int(readline())

total, n = 0, 0
while total < N:
    total = total * 2 + (n + 3)
    n += 1

print(moo(total, n + 2, N))
