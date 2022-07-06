import sys
input = sys.stdin.readline

seq = [2,1,2,3,4,5,4,3]
n = int(input())
res = n % 8
print(seq[res])