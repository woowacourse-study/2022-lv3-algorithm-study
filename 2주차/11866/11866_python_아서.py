import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())
table = deque(i for i in range(1, n + 1))

result = []
while table:
    table.rotate(-k)
    result.append(table.pop())

print('<' + ', '.join(map(str, result)) + '>')
