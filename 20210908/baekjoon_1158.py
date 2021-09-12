# baekjoon_1158
N, K = map(int, input().split())
li=[]

for i in range(1, N+1):
  li.append(i)

res = []  
num = 0  

for _ in range(N):
    num += K-1  
    if num >= len(li):   
        num = num%len(li)
    res.append(str(li.pop(num)))

print("<",", ".join(res)[:],">", sep='')