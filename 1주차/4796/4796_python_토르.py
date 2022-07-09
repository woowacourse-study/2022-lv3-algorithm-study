# TC 분석
# 연속하는 8일중 5일동안 사용가능. 휴가는 20일
case_count = 1
while True:
    L, P, V = map(int, input().split()) # 연속하는 P일중, L일동안 사용 가능. V일짜리 휴가 시작
    if L == 0 and P == 0 and V == 0:
        break

    answer = 0
    answer += (V // P) * L
    answer += min((V % P), L)
    print(f"Case {case_count}: {answer}")
    case_count += 1

