N = int(input())
members = [list(input().split()) for _ in range(N)]
members.sort(key = lambda x: (int(x[0])))
for member in members:
    print(member[0], member[1])
