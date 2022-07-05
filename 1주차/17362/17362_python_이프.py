
target = int(input()) - 1

answer = (target % 8 + 1)

if (answer > 5):
    answer = (8 - answer) + 2

print(answer)
