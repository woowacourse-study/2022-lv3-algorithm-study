n = int(input())
attackers = list(map(int, input().split(" ")))

max_kill_count = 0

attacker_index = 0
target_index = 1
kill_count = 0

while True:
    if target_index > n - 1:
        break

    attacker = attackers[attacker_index]
    target = attackers[target_index]

    if attacker >= target:
        kill_count += 1
        target_index += 1
    else:
        kill_count = 0
        attacker_index = target_index
        target_index = attacker_index + 1

    if max_kill_count < kill_count:
        max_kill_count = kill_count

print(max_kill_count)
