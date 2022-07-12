import sys

input = sys.stdin.readline

n = int(input())
seq = list(map(int, input().split()))[::-1]
add_seq = list()
last_number = 0

while True:
    if not seq:
        break

    if last_number + 1 == seq[-1]:
        last_number = seq.pop()
        continue

    while add_seq and add_seq[-1] == last_number + 1:
        last_number = add_seq.pop()

    add_seq.append(seq.pop())

while add_seq and add_seq[-1] == last_number + 1:
    last_number = add_seq.pop()

if last_number == n:
    print("Nice")
else:
    print("Sad")

