n = int(input())

answer = 0
# 1
if n%8 == 1:
    answer = 1
# 3
elif n%8 == 2 or n%8 == 0:
    answer = 2
# 3
elif n%4 == 3:
    answer = 3
# 5
elif n%8 == 5:
    answer = 5
else:
    answer = 4

print(answer)