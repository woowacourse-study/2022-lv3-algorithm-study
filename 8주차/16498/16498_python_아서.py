import sys

input = sys.stdin.readline

len_a, len_b, len_c = map(int, input().split())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split())))
c = sorted(list(map(int, input().split())))


def calculate_pen(x, y, z):
    return max(x, y, z) - min(x, y, z)


lt_a, lt_b, lt_c = 0, 0, 0

res = []
while True:
    tmp = [a[lt_a], b[lt_b], c[lt_c]]
    res.append(calculate_pen(a[lt_a], b[lt_b], c[lt_c]))
    min_idx = tmp.index(min(tmp))
    if min_idx == 0 and lt_a < len_a - 1:
        lt_a += 1
        continue
    elif min_idx == 1 and lt_b < len_b - 1:
        lt_b += 1
        continue
    elif min_idx == 2 and lt_c < len_c - 1:
        lt_c += 1
        continue
    break
print(min(res))

# res = 100000000
# for i in range(len_a):
#     for j in range(len_b):
#         for k in range(len_c):
#             res = min(res, calculate_pen(a[i], b[j], c[k]))
# print(res)
