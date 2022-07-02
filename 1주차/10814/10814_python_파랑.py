import sys

readline = sys.stdin.readline


# O(NlogN) 풀이
def sort_users1():
    count = int(readline())
    users = [readline() for _ in range(count)]

    users.sort(key=lambda x: int(x.split()[0]))
    for user in users:
        print(user, end="")


# O(N) 풀이
def sort_users2():
    count = int(readline())
    users = [[] for _ in range(201)]
    for _ in range(count):
        age, name = readline().split()
        users[int(age)].append(name)

    for age in range(1, 201):
        if users[age]:
            for name in users[age]:
                print("%d %s" % (age, name))


sort_users2()
