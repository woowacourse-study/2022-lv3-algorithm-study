N = int(input())
s0 = ['m', 'o', 'o']


def sol(n, k, l):
    if n <= 3:
        print(s0[n - 1])
        exit(0)
    next_len = 2 * l + k + 3
    if next_len < n:
        sol(n, k + 1, next_len)
    else:
        if l < n <= l + k + 3:
            if n - l == 1:
                print("m")
            else:
                print("o")
            exit(0)
        else:
            sol(n - (l + k + 3), 1, 3)


sol(N, 1, 3)
