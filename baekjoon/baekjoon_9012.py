# baekjoon_9012
N = int(input())

for _ in range(N):
    res = input()
    li = list(res)
    tmp = 0

    for i in li:
        if i == "(":
            tmp += 1
        elif i == ")":
            tmp -= 1
        if tmp < 0:
            print("NO")
            break
    
    if tmp > 0:
        print("NO")
    elif tmp == 0:
        print("YES")