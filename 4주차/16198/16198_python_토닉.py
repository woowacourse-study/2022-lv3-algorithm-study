import sys

input = sys.stdin.readline

N = int(input())

weights = list(map(int, input().rstrip().split()))

def calculate_energe(weights, total_energy):
    if len(weights) <= 2:
        return total_energy
    total_energys = []
    for i in range(1, len(weights)-1):
        temp_weight = weights[:]
        add_energy = temp_weight[i-1] * temp_weight[i+1]
        temp_weight.pop(i)
        total_energys.append(calculate_energe(temp_weight, total_energy + add_energy))
    return max(total_energys)

print(calculate_energe(weights, 0))
