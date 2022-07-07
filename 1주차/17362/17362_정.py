A = int(input())

finger_idx = ((A-1)%8) + 1

if finger_idx > 5:
    finger_idx = 10 - finger_idx

print(finger_idx)