import sys

s = sys.stdin.readline()[:-1]

count = 0
def check(value):
    global count
    right = len(value) - 1
    left = 0
    while left <= right:
        if value[left] != value[right]:
            return False
        left += 1
        right -= 1
    return True

for i in range(len(s)-1):
    checkValue = s+s[:i][::-1]
    if check(checkValue):
        print(len(checkValue))
        exit(0)
print(len(s)*2-1)