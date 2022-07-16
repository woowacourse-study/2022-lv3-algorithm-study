import sys
from collections import deque

input = sys.stdin.readline

def solve(deq):
    temp = deque()
    now = 1
    while len(deq):
        deq_now = deq.popleft()
        if deq_now == now:
            now += 1
        else:
            # 새로운 공간에서 조회
            if len(temp):
                temp_now = temp.popleft()
                if now == temp_now:
                    now += 1
                    deq.appendleft(deq_now)
                else:
                    temp.appendleft(temp_now)
                    temp.appendleft(deq_now)
            else:
                temp.appendleft(deq_now)
    else:
        while len(temp):
            if now != temp.popleft():
                return False
            else:
                now += 1
    return True

# 입력
_ = input()
deq = deque(map(int, input().rstrip().split()))
# 풀이, 출력
if solve(deq):
    print("Nice")
else:
    print("Sad")
