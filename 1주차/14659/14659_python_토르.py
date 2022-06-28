import sys

N = int(input())
hills = list(map(int, input().split()))

answer = -sys.maxsize

def count_right_max(start_index):
    count = 0
    for i in range(start_index + 1, len(hills)):
        if hills[i] < hills[start_index]:
            count += 1
        else:
            break
    return count

for i in range(len(hills)):
    right_max = count_right_max(i)
    answer = max(answer, right_max)

print(answer)