from itertools import combinations

def timeOverSolution1():
    input()
    sum = 0
    for (val1, val2) in combinations(list(map(int, input().split())), 2):
        sum += val1 * val2
    print(sum % 1_000_000_007)

def timeOverSolution2():
    N = int(input())
    values = list(map(int, input().split()))
    sum = 0
    for length in range(1, N):
        for idx1 in range(N-1):
            idx2 = idx1 + length
            if idx2 >= N: 
                break
            sum += values[idx1] * values[idx2]
    print(sum % 1_000_000_007)

def fastSolution():
    N = int(input())
    values = list(map(int, input().split()))
    value_raw_sum = sum(values)

    total_sum = 0
    for idx in range(N):
        cur = values[idx]
        total_sum += cur * (value_raw_sum - cur)

    print((total_sum // 2) % 1_000_000_007)
    
fastSolution()
