## 첫번째 풀이
registers = []

for _ in range(int(input())):
    age, name = input().split()
    registers.append([int(age), name])

for age, name in sorted(registers, key=lambda x:x[0]):
    print(age, name)


#############################
## 두번째 풀이 (첫번째 풀이에 비해 더 적은 시간복잡도)
people = [[] for i in range(201)]

for _ in range(int(input())):
    age,name = input().split()
    age = int(age)
    
    people[age].append(name)
    
for age in range(1, 201):
    names = people[age]
    if (len(names) == 0):
        continue
    for name in names:
        print(age,name)
