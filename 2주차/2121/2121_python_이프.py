import sys

readLine = sys.stdin.readline

def solution():
    size = int(readLine())
    row_length, col_length = map(int, readLine().split())

    positions = dict()
    for _ in range(size):
        row, col = map(int, readLine().split())
        if (row not in positions):
            positions[row] = set()
        positions[row].add(col)


    answer = 0
    for row in positions.keys():
        next_row = row + row_length
        if (next_row not in positions):
            continue

        cols = positions[row] & positions[next_row]
        for col in cols:
            next_col = col + col_length
            if (next_col in cols):
                answer += 1

    return answer


print(solution())
