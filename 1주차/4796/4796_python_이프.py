

def solution(L, P, V):

    if (P > V):
        return L

    answer = L * (V // P)
    remains = V % P

    if (remains > L):
        answer += L
    else:
        answer += remains
        
    return answer
    


prob_count = 0

while True:

    text = input()

    if (text == '0 0 0'):
        break

    prob_count += 1

    L, P, V = map(int, text.split())

    answer = solution(L, P, V)

    print("Case %d: %d" % (prob_count, answer))
