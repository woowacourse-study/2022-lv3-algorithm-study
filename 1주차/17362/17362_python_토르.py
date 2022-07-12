N = int(input())

if N % 8 == 1:
    print(1)
elif N % 8 == 2 or N % 8 == 0:
    print(2)
elif N % 8 == 3 or N % 8 == 7:
    print(3)
elif N % 8 == 4 or N % 8 == 6:
    print(4)
else:
    print(5)

