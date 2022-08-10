import sys
readLine = sys.stdin.readline

total, special_awards, main_awards = map(int, readLine().split())
scores = [list(map(int, readLine().split())) for _ in range(total)]

scores = sorted(scores, key=lambda x:x[1], reverse=True)
answer = scores[:main_awards]

scores = sorted(scores[main_awards:], key=lambda x:x[0], reverse=True)
answer.extend(scores[:special_awards])

print(sum([a for a,b in answer]))
