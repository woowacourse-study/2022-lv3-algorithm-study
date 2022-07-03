# 나이순 정렬
# https://www.acmicpc.net/problem/10814

from collections import defaultdict

n = int(input())

user_age_group = defaultdict(list)
for i in range(n):
    user = input().split(" ")
    age = int(user[0])
    name = user[1]

    user_age_group[age].append(name)

for age in sorted(user_age_group.keys()):
    for name in user_age_group.get(age):
        print(f"{age} {name}")
