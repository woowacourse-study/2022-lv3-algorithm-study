import sys

case_num = 1
while True:
    l, p, v = map(int, sys.stdin.readline().split())
    if l == 0 and p == 0 and v == 0:
        break
    result = (v // p) * l + min(l, v % p)
    print("Case %d: %d" % (case_num, result))
    case_num += 1
