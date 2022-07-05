import sys

input = sys.stdin.readline

N = int(input())

members = []

for idx in range(N):
    age, name = input().split()
    members.append((int(age), name, idx))

members.sort(key=lambda x:(x[0], x[2]))

for member in members:
    print(f'{member[0]} {member[1]}')