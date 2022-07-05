# 수학은 체육과목 입니다 2
# https://www.acmicpc.net/problem/17362

n = int(input())
l = [1, 2, 3, 4, 5, 4, 3, 2]
print(l[n % 8 - 1])