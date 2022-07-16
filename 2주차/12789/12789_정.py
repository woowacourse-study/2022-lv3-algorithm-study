N = int(input())
numbers = list(map(int, input().split()))

last_passed = 0
stack = []
can_eat = True

while len(numbers) > 0 or len(stack) > 0:
    if stack and stack[-1] == last_passed + 1:
        last_passed = stack.pop()
        continue
    if numbers:
        cur = numbers.pop(0)
        if cur == last_passed + 1:
            last_passed = cur
        else:
            stack.append(cur)
        continue
    can_eat = False
    break

if can_eat:
    print("Nice")
else:
    print("Sad")
