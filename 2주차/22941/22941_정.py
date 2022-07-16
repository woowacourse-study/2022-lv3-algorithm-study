hero_hp, hero_atk, enemy_hp, enemy_atk = map(int, input().split())
low_hp, heal = map(int, input().split())

hero_max_turn = (hero_hp - 1) // enemy_atk

enemy_max_healthy_turn = (enemy_hp - low_hp - 1) // hero_atk
enemy_inital_danger_hp = enemy_hp - ((enemy_max_healthy_turn + 1) * hero_atk)

enemy_max_turn = enemy_max_healthy_turn
if enemy_inital_danger_hp > 0:
    max_heal = min(heal, enemy_hp - enemy_inital_danger_hp)
    enemy_max_turn = (enemy_hp + heal - 1) // hero_atk

if hero_max_turn >= enemy_max_turn:
    print("Victory!")
else:
    print("gg")
