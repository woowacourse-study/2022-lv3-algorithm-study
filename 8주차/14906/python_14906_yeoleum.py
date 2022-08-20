def is_slump(x):
    num_slump = x.count('D') + x.count('E')
    if (len(x) != num_slump + x.count('F') + x.count('G')) or (x[0] != 'D' and x[0] != 'E') or x[-1] != 'G':
        return False
    elif num_slump == 1:
        return set(x.strip('DEG')) == {'F'}
    else:
        return is_slump(x.strip('DE').strip('F'))


def is_slimp(x):
    if x == 'AH':
        return True
    elif len(x) <= 3:
        return False
    elif x[0] != 'A' or x[-1] != 'C':
        return False
    else:
        return is_slump(x[1:-1]) or (x[1] == 'B' and is_slimp(x[2:-1]))


def is_slurpy(x):
    if len(x) <= 4:
        return False
    else:
        for i in range(2, len(x) - 2):
            if is_slimp(x[:i]) and is_slump(x[i:]):
                return True
        return False


N = int(input())
YESNO = []

for i in range(N):
    if is_slurpy(input()):
        YESNO.append('YES')
    else:
        YESNO.append('NO')

print('SLURPYS OUTPUT')
for YN in YESNO:
    print(YN)
print('END OF OUTPUT')
