from collections import deque
import math

HPY, ATKY, HPM, ATKM = map(int, input().split())  # 용사 Hp, 용사 ATK, 마왕 HP, 마왕 ATK
P, S = map(int, input().split())  # 스킬 발동 시점, 회복량

# 용사 공격 -> 마왕 체력 감소 -> 마왕 공격 -> 용사 체력 감소
# 마왕 체력이 1 이상 p이하이면 S 만큼 체력회복

iter_time = min((HPY - 1) // ATKM, (HPM - P - 1) // ATKY)

HPY -= iter_time * ATKM
HPM -= iter_time * ATKY

HPM -= ATKY

if HPM <= 0:
    print("Victory!")
    exit()

HPY -= ATKM
if HPM <= 0:
    print("gg")
    exit()

if 1 <= HPM <= P:
    HPM += S

iter_time = min((HPY - 1) // ATKM, (HPM - 1) // ATKY)

HPY -= iter_time * ATKM
HPM -= iter_time * ATKY

HPM -= ATKY
if HPM <= 0:
    print("Victory!")
else:
    print("gg")