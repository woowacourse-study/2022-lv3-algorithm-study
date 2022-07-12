def solution(dragons):
    maximum = 0
    count = 0
    answer = 0
    for i in dragons:
        if i < maximum:
            count += 1
        else:
            maximum = i
            answer = count
            count = 0
    return max(count, answer)


number = input()
cases = list(map(int, input().split()))

print(solution(cases))
