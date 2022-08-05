N = int(input())


def get_single_moo_length(k):
    return k + 3


def get_full_moo_length(k):
    n = 3
    for i in range(1, k + 1):
        n = (n * 2) + (i + 3)

    return n


k = 0
length = get_full_moo_length(0)
while length < N:
    length = get_full_moo_length(k + 1)
    k += 1

while True:
    single_side_length = get_full_moo_length(k - 1)  # 왼쪽 혹은 오른쪽(k-1 번째) moo 길이
    center_length = get_single_moo_length(k)  # 가운데 k번째 moo 길이

    if single_side_length < N <= single_side_length + center_length:
        # N이 가운데 moo를 가리킬 때
        if N - single_side_length == 1:
            print("m")
        else:
            print("o")

        break
    elif N <= single_side_length:
        if center_length <= 3: # moo만 남았을 때
            if N == 1:
                print("m")
            else:
                print("o")
            break

        # N이 왼쪽을 가리킬 때는 N은 그대로 두고 k만 -1 한다.
        k -= 1
    else:
        # N이 오른쪽을 가리킬 때는 오른쪽 부분만 떼내어 다시 돌린다
        left_center_length = single_side_length + center_length
        N -= left_center_length
        k -= 1
        
