import sys

readLine = sys.stdin.readline


def solution():
    days = int(readLine())
    cakes = [set()]+[set(list(map(int,readLine().split()))[1:]) for _ in range(days)]

    answer = dfs(days, cakes, 1, 0)
    if answer[-1] == -1:
        return [-1]
    return answer


def dfs(days, cakes, today, eaten):
    if (today == days):
        duplicated = False
        while cakes[today]:
            cake = cakes[today].pop()
            if cake == eaten:
                duplicated = True
                continue
            return [cake]
        else:
            if duplicated:
                cakes[today].add(eaten)
            return [-1]

    duplicated = False
    while cakes[today]:
        cake = cakes[today].pop()
        if cake == eaten:
            duplicated = True
            continue
        future = dfs(days, cakes, today+1, cake)
        if future[-1] != -1:
            return [cake] + future
    else:
        if duplicated:
            cakes[today].add(eaten)
        return [-1]


if __name__ == '__main__':
    answer = solution()
    print(*answer, sep='\n')
