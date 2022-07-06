import sys

input = sys.stdin.readline

i = 1
while True:
    l, p, v = map(int, input().split())
    if l == p == v == 0:
        break
    nums = (v // p) * l
    nums += min((v % p), l)
    print("Case %d: %d" % (i, nums))
    i += 1
