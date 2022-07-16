import sys

n = int(sys.stdin.readline())
a, b = map(int, sys.stdin.readline().split())
lst = []
for i in range(n):
    lst.append(tuple(map(int, sys.stdin.readline().split())))
lst = set(lst)
answer = 0
for x, y in lst:
    if (x+a, y) in lst and (x,y+b) in lst and (x+a, y+b) in lst:
        answer += 1

print(answer)