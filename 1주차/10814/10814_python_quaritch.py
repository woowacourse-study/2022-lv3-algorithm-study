# 10814번
# 나이순 정렬

import sys
readline = sys.stdin.readline

# 1st attempt
users = []

for i in range(int(readline())):
    users.append(readline().rstrip().split())

for user in sorted(users, key=lambda x: int(x[0])):
    print(f'{user[0]} {user[1]}')

# 2nd attempt
users = [[] for i in range(201)]

for i in range(int(readline())):
    age, name = readline().rstrip().split()
    users[int(age)].append(name)

for i in range(201):
    for name in users[i]:
        print(f'{i} {name}')
