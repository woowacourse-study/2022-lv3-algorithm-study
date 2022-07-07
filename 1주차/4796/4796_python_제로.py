case = 1

while 1:
    L, P, V = map(int, input().split())
    if L == 0 and P == 0 and V==0:
        break

    step1 = V // P
    step2 = V - step1 * P
    step2 = min(L, step2)
    result = step1 * L + step2

    # 출력
    print("Case %d: %d" %(case, result))
    case += 1
