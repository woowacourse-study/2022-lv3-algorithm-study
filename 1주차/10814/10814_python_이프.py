
registers = []

for _ in range(int(input())):
    age, name = input().split()
    registers.append([int(age), name])

for age, name in sorted(registers, key=lambda x:x[0]):
    print(age, name)
    
