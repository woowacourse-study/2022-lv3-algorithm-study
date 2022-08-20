from collections import deque
import sys
import copy
from collections import defaultdict
import heapq

n, k = map(int, input().split())
customers = list(map(int, input().split()))
waiting_queues = [deque() for _ in range(k)]

for customer in customers:
    for waiting_queue in waiting_queues:
        if not waiting_queue:
            waiting_queue.append(customer)
            break
        # 어떤 큐에 들어가든 오름차순이 유지되면 된다
        elif waiting_queue[-1] < customer:
            waiting_queue.append(customer)
            break
    else:
        print("NO")
        sys.exit(0)

print("YES")