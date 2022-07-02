from operator import itemgetter
import sys

n = int(sys.stdin.readline())
members = []

for i in range(n):
    age, name = map(str, sys.stdin.readline().split())
    members.append((int(age), name))

members.sort(key=itemgetter(0))

for member in members:
    print(member[0], member[1])
