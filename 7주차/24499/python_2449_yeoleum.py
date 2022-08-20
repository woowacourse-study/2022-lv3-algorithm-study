import sys

n,k = map(int,sys.stdin.readline().split())
pies = list(map(int,sys.stdin.readline().split())) * 2

left = 0
right = k - 1
sum = 0

for i in range(k):
    sum += pies[i]

answer = sum

while(True):
    sum -= pies[left]
    left = (left + 1) % n
    right = (right + 1) % n
    sum += pies[right]

    if(left == 0):
        break
    answer = max(answer, sum)

print(answer)
