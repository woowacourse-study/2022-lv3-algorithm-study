n = int(input())

# 리스트
lst = []
for i in range(n):
    age, name = map(str, input().split())
    lst.append((int(age), name))

# 정렬
lst.sort(key=lambda x: x[0])

# 출력
for user in lst:
    print(user[0], user[1])
