# 10814번
# 나이순 정렬

import sys

readline = sys.stdin.readline

users = []

for i in range(int(readline())):
    users.append(readline().rstrip().split())

for user in sorted(users, key=lambda x: int(x[0])):
    print(f'{user[0]} {user[1]}')
