input() 
nums = list(map(int, input().split())) 

def dfs(arr, total_sum): 
    global max_sum 
    
    size = len(arr) 
    if size == 2:
        if max_sum < total_sum:
            max_sum = total_sum
        return

    for cur_idx in range(1, size-1): 
        left = cur_idx - 1 
        right = cur_idx + 1 
        total_sum += arr[left] * arr[right]
        mid = arr.pop(cur_idx)

        dfs(list(arr), total_sum)
        
        arr.insert(cur_idx, mid)
        total_sum -= arr[left] * arr[right]

max_sum = 0

dfs(nums, 0)

print(max_sum)
