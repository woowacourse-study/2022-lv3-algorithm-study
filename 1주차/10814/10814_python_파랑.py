import sys

count = int(sys.stdin.readline())
users = [sys.stdin.readline() for _ in range(count)]

users.sort(key=lambda x: int(x.split()[0]))
for user in users:
    print(user, end="")
