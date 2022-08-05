from collections import defaultdict

N, K = map(int, input().split())
l = list(map(int, input().split()))

start_pointer = 0  # 시작 포인터
end_pointer = 0  # 끝 포인터
max_length = 0  # 최대 길이

count = defaultdict(int)
while end_pointer < N:
    cur_number = l[end_pointer]  # end_pointer가 가리키고 있는 숫자

    while count[cur_number] + 1 > K:
        # 특정 수의 개수가 K를 초과할 경우 start_pointer 를 뒤로 밀면서 수열의 범위를 좁힌다.
        count[l[start_pointer]] -= 1
        start_pointer += 1

    max_length = max(max_length, end_pointer - start_pointer + 1)
    # 최대 길이 갱신

    count[cur_number] += 1  # 개수 갱신
    end_pointer += 1  # end_pointer 이동

print(max_length)
