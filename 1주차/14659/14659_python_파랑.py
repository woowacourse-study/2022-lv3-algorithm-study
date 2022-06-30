import sys

n = int(sys.stdin.readline())

if n == 1:
    print(n)
else:
    n -= 2
    if n // 4 % 2 == 1:
        result = 4 - (n % 4)
    else:
        result = (n % 4) + 2
    print(result)
