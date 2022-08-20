import re

slump_rex = re.compile('([DE]F+)+G')


def is_slimp(s):
    if s == 'AH':
        return True
    elif re.compile('AB[A-Z]+C').match(s) is not None:
        return len(s) > 4 and is_slimp(s[2:-1])
    elif re.compile('A[A-Z]+C').match(s) is not None:
        return len(s) > 4 and (slump_rex.match(s[1:-1]) is not None)
    else:
        False


N = int(input())
arr = [input() for _ in range(N)]

print('SLURPYS OUTPUT')
for str in arr:
    if not list(slump_rex.finditer(str)):
        print('NO')
        continue
    s, e = list(slump_rex.finditer(str))[-1].span()
    if e == len(str) and is_slimp(str[:s]):
        print('YES')
    else:
        print('NO')
print('END OF OUTPUT')
