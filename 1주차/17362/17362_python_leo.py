def solution(number):
    remainder = number % 8
    if remainder in [0, 6, 7]:
        return (10 - number) % 8
    return remainder


n = int(input())
print(solution(n))
