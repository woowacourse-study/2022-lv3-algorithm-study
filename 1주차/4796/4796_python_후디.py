case_list = []

index = 0
while True:
    case = list(map(int, input().split(" ")))
    if case[0] == case[1] == case[2] == 0:
        break

    l, p, v = case

    day = v // p * l + min(l, v - v // p * p)

    print(f"Case {index + 1}: {day}")

    index += 1