import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
k = int(input())

# 한번에 정렬할 개수
hop = n//k
answer = []
for i in range(0, len(lst), hop):
    answer += sorted(lst[i:i+hop])

print(*answer)