def solution(words):
    queue = list(map(str, words))
    result = 0
    while queue:
        word = queue.pop(0)
        if not queue:
            return result * 2 + 1
        if word == queue[-1]:
            queue.pop()
        result += 1
    return result * 2


words = input()

print(solution(words))
