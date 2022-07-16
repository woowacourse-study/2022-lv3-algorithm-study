import sys

input = sys.stdin.readline

N = int(input())
A, B = map(int, input().rstrip().split())
li = set()
for _ in range(N):
    li.add(tuple(map(int, input().rstrip().split())))

def check(li, i):
    x, y = i
    if (x + A, y) not in li:
        return False
    if (x, y + B) not in li:
        return False
    if (x + A, y + B) not in li:
        return False
    return True

result = 0
for i in li:
    result += check(li, i)

print(result)
