N, K = map(int, input().split())

arr = list(map(int, input().split()))

left_idx = right_idx = 0
max_length = 1

count = [0] * 100_001
count[arr[0]] += 1

while True:
    length = right_idx - left_idx + 1
    next_idx = right_idx + 1

    if next_idx == N: break
    left = arr[left_idx]
    next = arr[next_idx]

    if count[next] == K:
        count[left] -= 1
        left_idx += 1
        continue

    count[next] += 1
    right_idx = next_idx
    max_length = max(max_length, length + 1)

print(max_length)
