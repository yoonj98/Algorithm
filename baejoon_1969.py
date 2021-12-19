# 백준 1969 : DNA 

n,m=map(int,input().split())
a=[]
c=[]
h=0

for i in range(n):
    a.append(input())

for i in range(m):
    b=[0]*4
    d=[]
    for j in range(n):
        if a[j][i] == 'A':
            b[0] += 1
        elif a[j][i] == 'C':
            b[1] += 1
        elif a[j][i] == 'G':
            b[2] += 1
        else:
            b[3] += 1
            
        d.append(a[j][i])
        
    if b[0] == max(b):
        t='A'
    elif b[1] == max(b):
        t='C'
    elif b[2] == max(b):
        t='G'
    else:
        t='T'
    c.append(t)
    h=h+len(d)-d.count(t)

print(''.join(c))
print(h)