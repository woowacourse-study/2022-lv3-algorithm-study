def solution(people):
    return sorted(people, key=lambda x: (x[1], x[0]))


people = []
for i in range(int(input())):
    line = input().split()
    people.append([i + 1, int(line[0]), line[1]])

for person in solution(people):
    print(f"{person[1]} {person[2]}")
