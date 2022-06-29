
def solution(L, P, V):

    if (P > V):
        return L

    answer = min(L, V % P)
    answer += L * (V // P)
    return answer

prob_count = 0

while True:
    text = input()
    if (text == '0 0 0'):
        break

    L, P, V = map(int, text.split())
    answer = solution(L, P, V)

    prob_count += 1
    print("Case %d: %d" % (prob_count, answer))
