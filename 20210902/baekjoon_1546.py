# baekjoon_1546

N = int(input())
score = list(map(int, input().split()))

M = max(score)

print(sum(score)*100/(M*N))