n, k = map(int, input().split())

people = list(range(1, n + 1))

sequence = []

cursor = k - 1
while len(people) > 1:
    sequence.append(people[cursor])
    del people[cursor]

    cursor = cursor + k -1
    if cursor >= len(people):
        cursor = cursor % len(people)

sequence.append(people[0])
print("<" + str.join(", ", map(str, sequence)) + ">")
