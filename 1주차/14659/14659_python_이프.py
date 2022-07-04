
size = int(input())
height_strs = input().split()

answer = 0
count = 0

current_height = int(height_strs[0])
for i in range(1, size):
    next_height = int(height_strs[i])
    if (current_height < next_height):
        current_height = next_height
        
        answer = max(answer, count)
        count = 0
        continue
        
    count += 1

answer = max(answer, count)
print(answer)
