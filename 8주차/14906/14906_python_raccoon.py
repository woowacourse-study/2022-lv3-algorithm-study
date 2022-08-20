import sys

input = sys.stdin.readline
n = int(input())


def slump(s):
    if len(s) <= 1:
        return False
    if s[0] != 'D' and s[0] != 'E':
        return False
    if s[-1] != 'G':
        return False

    for i in range(1, len(s)-1):
        if s[i] == "F":
            continue
        if s[i] == "D" or s[i] == 'E':
            return slump(s[i:])

    return True


def slimp(s):
    if len(s) < 2:
        return False

    if s[0] != 'A':
        return False

    if len(s) == 2:
        if s[1] != 'H':
            return False
        else:
            return True

    if s[-1] != 'C':
        return False

    if s[1] == 'B':
        if len(s[2:-1]) == 0:
            return True
        return slimp(s[2:-1])
    elif s[1] == 'D' or s[1] == 'E':
        if len(s[1:-1]) == 0:
            return True
        return slump(s[1:-1])
    else:
        return False


print('SLURPYS OUTPUT')
for _ in range(n):
    s = input().strip()
    h_index = s.rfind("H")
    c_index = s.rfind("C")
    separate_index = -1
    if h_index != -1:
        separate_index = max(separate_index, h_index)
    if c_index != -1:
        separate_index = max(separate_index, c_index)

    if separate_index == -1 or separate_index == 0 or separate_index == len(s)-1:
        print("NO")
    else:
        if slimp(s[:separate_index+1]) and slump(s[separate_index+1:]):
            print("YES")
        else:
            print("NO")
print('END OF OUTPUT')
