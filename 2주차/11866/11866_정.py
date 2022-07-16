N, K = map(int, input().split())

nums = [n for n in range(1, N+1)]
num_order = []

counter = 0
while nums:
    cur = nums.pop(0)
    counter += 1
    if counter < K:
        nums.append(cur)
        continue
    num_order.append(cur)
    counter = 0

num_order = ", ".join(map(str, num_order))
print(f'<{num_order}>')

