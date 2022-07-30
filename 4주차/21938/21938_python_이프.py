import sys

readLine = sys.stdin.readline


def check(matrix, rows, cols, start_row, start_col):
    targets = set()
    targets.add(tuple([start_row, start_col]))

    while targets:
        row, col = targets.pop()
        if matrix[row][col]:
            continue

        matrix[row][col] = True

        for x,y in [(row-1, col), (row+1, col), (row, col-1), (row, col+1)]:
            if x < 0 or y < 0 or rows <= x or cols <= y:
                continue
            if matrix[x][y]:
                continue
            targets.add(tuple([x,y]))
    return


def solution(rows, cols, arr, limit):

    matrix = []
    for row in range(rows):
        matrix.append([])
        for col in range(cols):
            start = col * 3
            end = (col + 1) * 3
            matrix[row].append(sum(map(int, arr[row][start:end])) // 3 < limit)

    result = 0
    for row in range(rows):
        for col in range(cols):
            if matrix[row][col]:
                continue
            check(matrix, rows, cols, row, col)
            result += 1
    return result


if __name__ == "__main__":
    rows, cols = map(int, readLine().split())
    arr = [readLine().split() for _ in range(rows)]
    limit = int(readLine())

    answer = solution(rows, cols, arr, limit)
    print(answer)
