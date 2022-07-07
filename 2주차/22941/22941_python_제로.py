import sys

playerHP, playerATK, bossHP, bossATK = map(int, sys.stdin.readline().split())
p, s = map(int, sys.stdin.readline().split())
bossMoreChance = True

while True:
    # 몫을 통해 처음 한번 빼고 시작
    mok = 0
    if bossMoreChance == True:
        mok = max(min((bossHP-p)//playerATK-1, playerHP//bossATK-1), 0)
    else:
        mok = max(min(bossHP // playerATK-1, playerHP // bossATK-1), 0)
    bossHP -= playerATK * mok
    playerHP -= bossATK * mok
    # 1
    bossHP -= playerATK
    # 2
    if bossHP <= 0:
        print("Victory!")
        break
    # 3
    playerHP -= bossATK
    # 4
    if playerHP <= 0:
        print("gg")
        break
    # 5
    if (1 <= bossHP <= p) and bossMoreChance == True:
        bossHP += s
        bossMoreChance = False
