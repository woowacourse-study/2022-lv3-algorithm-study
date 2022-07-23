text = input()

for i in range(0, len(text)):
    sliced = text[i:]
    center_index = len(sliced) // 2
    if len(sliced) % 2 > 0:
        sliced = sliced[:center_index] + sliced[center_index + 1:]

    center_index = len(sliced) // 2
    left = sliced[:center_index]
    right = sliced[center_index:]
    right_reversed = right[::-1]

    if left == right_reversed:
        print(len(text) + i)
        break