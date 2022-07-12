import sys
from math import ceil

input = sys.stdin.readline

me_hp, me_atk, you_hp, you_atk = map(int, input().split())
p, s = map(int, input().split())

my_death_turn = ceil(me_hp / you_atk)

just_before_skill_hp = (you_hp - p) % me_atk + p
if p < just_before_skill_hp <= me_atk:
    your_death_turn = ceil(you_hp / me_atk)
else:
    your_death_turn = ceil((you_hp + s) / me_atk)

if my_death_turn >= your_death_turn:
    print("Victory!")
else:
    print("gg")
