# 캠핑
# https://www.acmicpc.net/problem/4796

case_list = []

index = 0
while True:
    l, p, v = list(map(int, input().split(" ")))
    if not l + p + v:
        break

    day = v // p * l + min(l, v - (v // p) * p)

    print(f"Case {index + 1}: {day}")

    index += 1