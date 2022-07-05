def solution(case):
    return (case[2] // case[1]) * case[0] + min((case[2] % case[1]), case[0])


k = 1
while True:
    line = list(map(int, input().split()))
    if sum(line) == 0:
        break
    print(f"Case {k}: {solution(line)}")
    k += 1
