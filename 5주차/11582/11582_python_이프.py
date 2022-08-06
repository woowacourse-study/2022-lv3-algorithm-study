import sys

readLine = sys.stdin.readline


def solution():
    size = int(readLine())
    shops = [int(i) for i in readLine().split()]
    depth = int(readLine())

    piece_size = size // depth
    answer = []
    for i in range(depth):
        start = i * piece_size
        end = (i+1) * piece_size
        answer.extend(sorted(shops[start:end]))

    print(*answer)


if __name__ == "__main__":
    solution()
