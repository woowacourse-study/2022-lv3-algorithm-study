from collections import deque
import sys

# 가장 긴 팰린드롬을 구하자. 주어진 문자열 길이에서 가장 긴 팰린드롬 길이를 빼면된다.
# 만약 주어진 문자열이 팰린드롬이라면 0을 반환하면 된다

string = input()
min_length = sys.maxsize

if string == string[::-1]:
    print(len(string))
    exit()


for i in range(len(string)):
    for j in range(i, len(string)):
        if string[i:j+1] == string[i:j+1][::-1]:
            if not string[j+1:]:
                min_length = min(min_length, len(string) - len(string[i:j+1]) + len(string))

print(min_length)