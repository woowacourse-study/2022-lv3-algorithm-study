import sys


def find_finger_number1(num):
    if num == 1:
        print(num)
    else:
        num -= 2
        if num // 4 % 2 == 1:
            result = 4 - (num % 4)
        else:
            result = (num % 4) + 2
        print(result)


def find_finger_number2(num):
    result = (num - 1) % 8 + 1

    if result >= 5:
        result = 10 - result

    print(result)


def find_finger_number3(num):
    remainder = num % 8

    if remainder == 6:
        print(4)
    elif remainder == 7:
        print(3)
    elif remainder == 0:
        print(2)
    else:
        print(remainder)


n = int(sys.stdin.readline())
find_finger_number2(n)
