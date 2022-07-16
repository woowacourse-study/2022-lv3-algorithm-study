n, k = map(int, input().split())

index = 0
li = [x for x in range(1, n+1)]
result = []

while len(li) != 0:
    index += k-1
    if index > len(li) - 1:
        index %= len(li)
    tmp = li.pop(index)
    result.append(tmp)

print("<" + ", ".join(map(str, result)) + ">")
