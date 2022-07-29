N = int(input())
nums = list(map(int, input().split()))

max_prevs = [0, 999_999_999]

for idx in range(N):
    cur = nums[idx]
    max_idx = len(max_prevs) - 1

    if max_prevs[max_idx] < cur:
        max_prevs.append(cur)
    
    for idx in range(max_idx-1, -1, -1):
        if max_prevs[idx] < cur and max_prevs[idx + 1] > cur:
            max_prevs[idx + 1] = cur

print(len(max_prevs) - 1)
