from collections import deque
import sys
import copy
from collections import defaultdict

input = sys.stdin.readline
# 총 학생수, 특별상 학생수, 본상 학생수 k
# 7 2 3
N, M, K = map(int, input().split())
student_records = []

for _ in range(N):
    a, b = map(int, input().split())
    student_records.append((a, b))


owner_like_records = sorted(student_records[:], key=lambda x: (-x[0], x[1]))
referee_like_records = sorted(student_records[:], key=lambda x: (-x[1], x[1]))

owner_mk_set = set(owner_like_records[:][:M+K])
referee_mk_set = set(referee_like_records[:][:K])

owner_should_pick = sorted(list(owner_mk_set - referee_mk_set), key=lambda x: (-x[0], x[1]))[:M]
referee_pick = set()

for i in range(len(referee_like_records)):
    if referee_like_records[i] not in owner_should_pick:
        if len(referee_pick) == K:
            break
        referee_pick.add(referee_like_records[i])

answer = 0

for record in owner_should_pick:
    answer += record[0]

for record in referee_pick:
    answer += record[0]

print(answer)
print(10**9)