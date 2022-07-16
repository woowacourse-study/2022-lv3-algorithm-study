from math import ceil
import sys

hpPlayer, atkPlayer, hpMonster, atkMonster = map(
    int, sys.stdin.readline().split())
p, s = map(int, sys.stdin.readline().split())

playerDie = ceil(hpPlayer / atkMonster)
if (hpMonster - p) % atkPlayer and (hpMonster - p) % atkPlayer + p <= atkPlayer:
    monsterDie = ceil(hpMonster / atkPlayer)
else:
    monsterDie = ceil((hpMonster + s) / atkPlayer)

print("Victory!" if playerDie >= monsterDie else "gg")
