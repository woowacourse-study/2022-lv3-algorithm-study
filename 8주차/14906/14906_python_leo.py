import re


def is_slurpy(word):
    slump_regex = re.compile('([DE]F+)+G')
    slump = list(slump_regex.finditer(word))
    if not slump:
        return False
    start_index, end_index = slump[0].span()
    if end_index == len(word) and is_slimp(word[:end_index]):
        return True
    return False


def is_slimp(word):
    slump_regex = re.compile('([DE]F+)+G')
    if word == 'AH':
        return True
    elif re.compile('AB[A-Z]+C').match(word) is not None:
        return len(word) > 4 and is_slimp(word[2:-1])
    elif re.compile('A[A-Z]+C').match(word) is not None:
        return len(word) > 4 and (slump_regex.match(word[1:-1]) is not None)
    return False


def solution(N, words):
    answer = []
    for word in words:
        answer.append(is_slurpy(word))
    return answer


def solution_word(is_true):
    if is_true:
        return "YES"
    return "NO"


N = int(input())
words = [input() for _ in range(N)]


print('SLURPYS OUTPUT')
for i in solution(N, words):
    print(solution_word(i))
print('END OF OUTPUT')
