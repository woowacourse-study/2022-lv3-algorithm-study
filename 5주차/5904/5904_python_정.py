target = int(input())

k = 0
S_num = 0
while True:
    prev = S_num
    total_range = prev + (k+3) + prev
    if total_range < target:
        k += 1
        S_num = total_range
        continue

    if target == prev + 1:
        print("m")
        break
    if target <= prev + (k+3):
        print("o")
        break
    # if target <= total_range:
    target = target - (prev + (k+3))
    k = 0
    S_num = 0
