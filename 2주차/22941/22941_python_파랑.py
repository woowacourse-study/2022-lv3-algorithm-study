# 22941 RPG 마스터 오명진

import sys

readline = sys.stdin.readline

warrior_hp, warrior_atk, monster_hp, monster_atk = map(int, readline().split())
p, s = map(int, readline().split())

hp_flag = True
while True:
    cnt = 0
    if hp_flag:
        cnt = max(min(warrior_hp // monster_atk, (monster_hp - p) // warrior_atk), 1)
    else:
        cnt = max(min(warrior_hp // monster_atk, monster_hp // warrior_atk), 1)
    warrior_hp -= cnt * monster_atk
    monster_hp -= cnt * warrior_atk

    if warrior_hp <= 0 or monster_hp <= 0:
        break

    if hp_flag and 1 <= monster_hp <= p:
        hp_flag = False
        monster_hp += s

if monster_hp <= 0:
    print("Victory!")
else:
    print("gg")
