import sys

input = sys.stdin.readline


def solution(n, cards):
    for _ in range(n):
        pieces = map(int, input().split())
        left_cards = cards[:13]
        right_cards = cards[13:]
        answer = []
        for index, value in enumerate(pieces):
            if index % 2 == 0:
                answer.extend(right_cards[:value])
                right_cards = right_cards[value:]
            else:
                answer.extend(left_cards[:value])
                left_cards = left_cards[value:]
        cards = answer.copy()
    return cards.index(77) + 1


n = int(input())
cards = [77] + [i + 1 for i in range(26)]
print(solution(n, cards))
