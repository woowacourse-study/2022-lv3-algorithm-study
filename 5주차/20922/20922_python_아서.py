import sys

input = sys.stdin.readline

n, k = map(int, input().split())
seq = list(map(int, input().split()))

lt = 0
rt = 0
check = [0] * (max(seq) + 1)
res = 0

while rt < n:
    if check[seq[rt]] < k:
        check[seq[rt]] += 1
        rt += 1
    else:
        check[seq[lt]] -= 1
        lt += 1
        res = max(res, rt - lt)
print(res)
