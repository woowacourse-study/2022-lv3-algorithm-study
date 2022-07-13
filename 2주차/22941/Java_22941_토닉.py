## 실패.. 정답을 모르겠습니다 ㅠㅠ
import math
import sys

input = sys.stdin.readline

용사_HP, 용사_ATK, 마왕_HP, 마왕_ATK = map(int, input().rstrip().split())
마왕_스킬_HP, 마왕_스킬_회복량 = map(int, input().rstrip().split())

마왕_죽는_회수 = 0
용사_죽는_회수 = math.ceil(용사_HP / 마왕_ATK)

if (마왕_HP - 마왕_스킬_HP) % 용사_ATK and (마왕_HP - 마왕_스킬_HP) % 용사_ATK + 마왕_스킬_HP <= 용사_ATK:
    마왕_죽는_회수 = math.ceil(마왕_HP / 용사_ATK)
else:
    공격_회수, 남은_체력 = divmod(마왕_HP - 마왕_스킬_HP, 용사_ATK)
    마왕_죽는_회수 = 공격_회수 + math.ceil((남은_체력 + 마왕_스킬_회복량 + 마왕_스킬_HP) / 용사_ATK) + 1

print(마왕_죽는_회수, 용사_죽는_회수)
if 마왕_죽는_회수 <= 용사_죽는_회수:
    print("Victory!")
else:
    print("gg")
