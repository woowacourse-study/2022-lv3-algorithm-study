limit = 1000000007

size = int(input())

numbers = list(map(int, input().split()))
total = sum(numbers) % limit

answer = 0
for i in range(size-1):
    current = numbers[i]

    total -= current
    if (total < 0):
        total += limit

    answer += current * total
    answer %= limit

print(answer)
