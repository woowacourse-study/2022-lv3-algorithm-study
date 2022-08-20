import sys
readLine = sys.stdin.readline

def solution():
    size = int(readLine())

    position = 1
    for _ in range(size):
        start = 1
        if position > 13:
            start = 0
            position -= 13

        sequences = list(map(int, readLine().split()))
        for i in range(start, len(sequences), 2):
            seq = sequences[i]
            if position <= seq:
                break
            position -= seq
        position = sum(sequences[:i]) + position
    return position


print(solution())
