from collections import deque
import sys
import copy
from collections import defaultdict
import heapq

print("SLURPYS OUTPUT")
N = int(input())


def is_slump(string):
    if len(string) >= 1 and not (string[0] == "D" or string[0] == "E"):
        return False
    for i in range(1, len(string)):
        if len(string) > 2 and string[1] != "F":
            return False
        if len(string) >= 1 and i == len(string) - 1:
            return string[-1] == "G"
        if string[i] == "F":
            continue
        else:
            return is_slump(string[i:])

def is_slimp(string):
    if len(string) >= 1 and string[0] != "A":
        return False

    if len(string) < 2:
        return False

    if len(string) == 2:
        return string[1] == "H"
    else:
        if len(string) >= 2 and string[0] == "A" and string[1] == "B" and is_slimp(string[2:-1]) and string[-1] == "C":
            return True
        elif len(string) >= 2 and string[0] == "A" and is_slump(string[1:-1]) and string[-1] == "C":
            return True
        else:
            return False


def is_slurpy(string):
    for i in range(len(string)):
        if is_slimp(string[:i]):
            if is_slump(string[i:]):
                return True
    return False


for _ in range(N):
    sentence = input()
    result = is_slurpy(sentence)
    if result:
        print("YES")
    else:
        print("NO")
print("END OF OUTPUT")
