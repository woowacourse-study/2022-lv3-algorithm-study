raw = input()

N = len(raw)

max_palindrome_count = 0
max_palindrome_idx = (0, 0)

for start_idx in range(N-1):
    is_palindrome = True
    end_idx = N-1
    for i in range(end_idx - start_idx):
        if start_idx + i > end_idx - i: break
        if raw[start_idx + i] != raw[end_idx - i]:
            is_palindrome = False

    if is_palindrome:
        cur_palindrome_count = end_idx - start_idx + 1
        if max_palindrome_count < cur_palindrome_count:
            max_palindrome_count = cur_palindrome_count
            max_palindrome_idx = (start_idx, end_idx)

if max_palindrome_count == 0:
    print(N + N - 1)
else:
    print(N + N - max_palindrome_count)
