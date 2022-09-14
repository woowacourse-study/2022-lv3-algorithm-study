import sys, heapq

input = sys.stdin.readline

N, M, K = map(int, input().split())

heap = []

for _ in range(N):
    a, b = map(int, input().split())
    heapq.heappush(heap, (-b, a))

sum = 0

for _ in range(K):
    (_, a) = heapq.heappop(heap)
    sum += a

new_heap = []
for _ in range(N - K):
    (b, a) = heapq.heappop(heap)
    heapq.heappush(new_heap, -a)

for _ in range(M):
    sum -= heapq.heappop(new_heap)

print(sum)