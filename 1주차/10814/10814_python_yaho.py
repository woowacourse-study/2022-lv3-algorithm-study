from operator import itemgetter
import sys
readline = sys.stdin.readline

n = int(readline())
members = [readline() for _ in range(n)]

members.sort(key=int(itemgetter(0)))

for member in members:
    print(member[0], member[1])
