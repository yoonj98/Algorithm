# 백준 11047 : 동전 0

N, K = map(int, input().split())
result = 0
coins = []
for i in range(N):
    coin = int(input())
    coins.append(coin)
coins = sorted(coins, reverse=True)

for i in coins:
    if i > K:
        continue
    else:
        while i <= K:
            K -= i
            result += 1

print(result)