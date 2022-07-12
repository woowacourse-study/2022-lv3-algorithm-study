import sys

case_num = 0

for line in sys.stdin:
    L, P, V = map(int, line.split())
    if L == 0: break

    case_num += 1
    full_days = (V//P) * L
    leftover_days = min(L, (V%P))
    count = full_days + leftover_days

    print(f'Case {case_num}: {count}')