import sys
input = sys.stdin.readline

IDX = -1

for _ in range(int(input())):
    size, times = map(int, input().split())

    results = dict()
    for i in range(size):
        results[(i, IDX)] = 0
        results[(IDX, i)] = 0

    for row in range(size):
        items = input().split()
        for col in range(size):
            item = int(items[col])
            results[(row, IDX)] += item
            results[(IDX, col)] += item

    for __ in range(times):
        r1, c1, r2, c2, v = map(int,input().split())
        for i in range(r1 - 1, r2):
            results[(i, IDX)] += v * (c2 - c1 + 1)
        for i in range(c1 - 1, c2):
            results[(IDX, i)] += v * (r2 - r1 + 1)

    answers = ['', '']
    for i in range(size):
        answers[0] += str(results[(i, IDX)]) + ' '
        answers[1] += str(results[(IDX, i)]) + ' '

    for answer in answers:
        print(answer[:-1])
