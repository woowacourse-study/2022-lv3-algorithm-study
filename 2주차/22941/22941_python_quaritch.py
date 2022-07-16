# 22941번
# RPG 마스터 오명진

import math
import sys
readline = sys.stdin.readline

heroHP, heroATK, demonKingHP, demonKingATK = map(int, readline().rstrip().split())
P, S = map(int, readline().rstrip().split())

heroResistance = math.ceil(heroHP / demonKingATK)

if heroATK >= (demonKingHP - P) % heroATK + P and (demonKingHP - P) % heroATK:
    demonKingResistance = math.ceil(demonKingHP / heroATK)
else:
    demonKingResistance = math.ceil((demonKingHP + S) / heroATK)

print("Victory!" if heroResistance >= demonKingResistance else "gg")
