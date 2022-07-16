VICTORY = "Victory!"
GG = "gg"

def solution():
    global hero_hp, hero_atk, devil_hp, devil_atk
    global devil_heal_condition, devil_heal_gauge
    global hero_quotient, hero_remainder, devil_quotient, devil_remainder

    if (hero_quotient < devil_quotient):
        if (devil_quotient - hero_quotient == 1):
            if (hero_remainder != 0 and devil_remainder == 0):
                return VICTORY
        return GG

    if (devil_remainder <= devil_heal_condition):
        if (devil_remainder == 0 and devil_heal_condition < hero_atk):
            return VICTORY
        return checkWithHeal()

    if (devil_heal_condition < hero_atk + devil_remainder):
        return VICTORY

    return checkWithHeal()


def checkWithHeal():
    global hero_hp, hero_atk, devil_hp, devil_atk
    global devil_heal_condition, devil_heal_gauge
    global hero_quotient, hero_remainder, devil_quotient, devil_remainder

    devil_hp += devil_heal_gauge
    devil_quotient = devil_hp // hero_atk
    devil_remainder = devil_hp % hero_atk

    if (hero_quotient < devil_quotient):
        if (devil_quotient - hero_quotient == 1):
            if (hero_remainder != 0 and devil_remainder == 0):
                return VICTORY

        return GG

    if (hero_quotient == devil_quotient):
        if (hero_remainder == 0):
            if (devil_remainder == 0):
                return VICTORY
            return GG

    return VICTORY


hero_hp, hero_atk, devil_hp, devil_atk = map(int, input().split())
devil_heal_condition, devil_heal_gauge = map(int, input().split())

hero_quotient = hero_hp // devil_atk
hero_remainder = hero_hp % devil_atk
devil_quotient = devil_hp // hero_atk
devil_remainder = devil_hp % hero_atk

print(solution())
