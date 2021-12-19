N = int(input())

for i in range(1, N+1):
    print(" "*(N-i)+"*"*i+"*"*(i-1))
for j in range(N-1, 0, -1):
    print(" "*(N-j)+"*"*j+"*"*(j-1))