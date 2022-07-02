import sys
i = 1
while True:
    l, p, v = map(int, input().split())
    if l+p+v == 0:
        break
    result = v//p*l + min(v % p, l)
    print("Case %d: %d" % (i, result))
    i += 1
